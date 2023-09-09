package com.github.otr.academy.scraper.task.step.handler

import com.github.otr.academy.scraper.cache_handler.BaseCacheHandler
import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.dto.step.StepContainerDTO
import com.github.otr.academy.scraper.dto.step.StepDTO
import com.github.otr.academy.scraper.task.step.request.StepRequest

import com.google.gson.Gson

import javax.inject.Inject

/**
 *
 */
internal class ParseJsonStepHandler @Inject constructor(
    // TODO: Replace Gson with P2I
) : BaseCacheHandler() {

    override val handlerName: String = "Parse JSON to Step DTO handler"

    override fun canHandle(request: Cacheable): Boolean {
        return request.sourceData != null
    }

    override fun handle(request: Cacheable): Cacheable {
        val rawJson: String = request.sourceData
            ?: throw IllegalArgumentException("Source data should not be null")

        // TODO: Replace concrete realization of Gson with abstract JSON Parser
        val stepContainerDTO: StepContainerDTO = Gson()
            .fromJson(rawJson, StepContainerDTO::class.java)

        val stepDTO: StepDTO = stepContainerDTO.steps.first()
        // TODO: Remove type casts
        val response = (request as StepRequest).copy(dto = stepDTO)

        return response
    }

}
