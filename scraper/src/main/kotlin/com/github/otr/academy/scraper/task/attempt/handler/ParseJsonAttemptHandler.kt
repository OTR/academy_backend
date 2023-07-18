package data.scraper.task.attempt.handler

import com.google.gson.Gson

import data.scraper.cache_handler.BaseCacheHandler
import data.scraper.dto.attempt.AttemptContainerDTO
import data.scraper.dto.attempt.AttemptDTO
import data.scraper.task.attempt.request.AttemptRequest
import data.scraper.cache_handler.Cacheable

/**
 *
 */
object ParseJsonAttemptHandler : BaseCacheHandler() {

    override val handlerName: String = "Parse JSON to Attempt DTO handler"

    override fun canHandle(request: Cacheable): Boolean {
        return request.sourceData != null
    }

    override fun handle(request: Cacheable): Cacheable {
        val rawJson: String = request.sourceData
            ?: throw IllegalArgumentException("Source data should not be null")

        val stepContainerDTO: AttemptContainerDTO = Gson() // TODO: Replace with DI
            .fromJson(rawJson, AttemptContainerDTO::class.java)

        val attemptDTO: AttemptDTO = stepContainerDTO.attempts.first()

        val response = (request as AttemptRequest).copy(dto = attemptDTO) // TODO: Remove type cast

        return response
    }

}
