package data.scraper.task.attempt

import data.scraper.cache_handler.Cacheable
import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.core.task.BaseParseTask
import data.scraper.task.attempt.handler.ParseJsonAttemptHandler
import data.scraper.task.attempt.request.AttemptRequest

/**
 *
 */
class ParseAttemptTask(
    private val request: AttemptRequest
) : BaseParseTask<AttemptRequest>(request) {

    override val parseJsonHandler: Handler<Cacheable> = ParseJsonAttemptHandler

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain = buildChainOfHandlers()
        val response = chain(request)

//         TODO: check response
        if (response.dto != null) {
            return true to listOf(SaveAttemptToDbTask(response))
        }
        return false to emptyList()
    }

}
