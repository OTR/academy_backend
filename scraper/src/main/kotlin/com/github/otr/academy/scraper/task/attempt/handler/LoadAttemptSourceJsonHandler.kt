package data.scraper.task.attempt.handler

import data.config.Config
import data.scraper.cache_handler.BaseCacheHandler
import data.scraper.cache_handler.Cacheable
import domain.repository.StepRepository

import org.jsoup.Connection.Response

import javax.inject.Inject

class LoadAttemptSourceJsonHandler @Inject constructor(
    repository: StepRepository
) : BaseCacheHandler() {

    override val handlerName: String = "Load Source JSON from remote server"

    private val delayInMillis: Long = Config.getDelayBetweenHttpRequests()

    private val attemptLoader: AttemptLoader = AttemptLoader // TODO: DI

    private val theorySteps: List<Int> = repository.getAllTheoryStepsIds()

    override fun canHandle(request: Cacheable): Boolean {
        return request.sourceData == null && request.type.id !in theorySteps
    }

    /**
     * Set the maximum bytes to read from the (uncompressed) connection into the body,
     * before the connection is closed,
     * and the input truncated (i.e. the body content will be trimmed).
     * The default maximum is 2MB. A max size of 0 is treated as an infinite amount
     * (bounded only by your patience and the memory available on your machine).
     */
    override fun handle(request: Cacheable): Cacheable {
        val stepId: Int = request.type.id
        val response: Response = attemptLoader.loadAttempt(stepId)

        if (response.statusCode() in 200 until 300) {
            val rawJson = response.body()
            request.sourceData = rawJson
        } else {
            //
            val rawJson = response.body()
            when {
                rawJson.length < 60 && rawJson.contains("Invalid pk") -> {
                    logger.trace("Database row with Primary key #${stepId} does not exist")
                }
                else -> {
                    logger.error("Response code is: ${response.statusCode()}                                <---------------------")
                }
            }

        }

        return request
    }

    override fun handleOrSkip(request: Cacheable): Cacheable {
        return if (canHandle(request)) {
            logger.debug("Handling `$handlerName` $ARROW")
            val resp = handle(request)
            // FIXME: Make a delay of 100 millis before next HTTP Request
            Thread.sleep(delayInMillis)
            resp
        } else {
            printNegative()
            request
        }
    }

}
