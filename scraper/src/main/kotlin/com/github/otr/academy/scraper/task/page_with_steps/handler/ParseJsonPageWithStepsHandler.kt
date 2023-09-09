package com.github.otr.academy.scraper.task.page_with_steps.handler

import com.github.otr.academy.scraper.cache_handler.BaseCacheHandler
import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.dto.step.StepContainerDTO
import com.github.otr.academy.scraper.dto.step.StepDTO
import com.github.otr.academy.scraper.task.page_with_steps.request.PageWithStepsRequest

import com.google.gson.Gson

import javax.inject.Inject

/**
 *
 */
internal class ParseJsonPageWithStepsHandler @Inject constructor(
    // TODO: replace Gson with P2I
) : BaseCacheHandler() {

    override val handlerName: String = "Parse JSON Page with Steps to List Of Step DTO handler"

    override fun canHandle(request: Cacheable): Boolean {
        return request.sourceData != null
    }

    override fun handle(request: Cacheable): Cacheable {
        val rawJson: String = request.sourceData
            ?: throw IllegalArgumentException("Source data should not be null")

        // TODO : Decouple Gson realization DI
        val stepContainerDTO: StepContainerDTO = Gson()
            .fromJson(rawJson, StepContainerDTO::class.java)

        val listOfStepDTO: List<StepDTO> = stepContainerDTO.steps.toList()
        // TODO: Remove type cast
        val response = (request as PageWithStepsRequest)
            .copy(listOfStepDTO = listOfStepDTO)

        return response
    }

}
