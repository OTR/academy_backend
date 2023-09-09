package com.github.otr.academy.scraper.task.attempt.handler

import com.github.otr.academy.scraper.cache_handler.BaseCacheHandler
import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.dto.attempt.AttemptContainerDTO
import com.github.otr.academy.scraper.dto.attempt.AttemptDTO
import com.github.otr.academy.scraper.task.attempt.request.AttemptRequest

import com.google.gson.Gson

import javax.inject.Inject

/**
 *
 */
internal class ParseJsonAttemptHandler @Inject constructor(
    // TODO: Replace Gson with P2I
) : BaseCacheHandler() {

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
        // TODO: Remove type cast
        val response = (request as AttemptRequest).copy(dto = attemptDTO)

        return response
    }

}
