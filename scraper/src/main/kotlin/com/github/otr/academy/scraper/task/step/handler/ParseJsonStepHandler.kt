package data.scraper.task.step.handler

import com.google.gson.Gson

import data.scraper.cache_handler.BaseCacheHandler
import data.scraper.dto.step.StepContainerDTO
import data.scraper.dto.step.StepDTO
import data.scraper.cache_handler.Cacheable
import data.scraper.task.step.request.StepRequest

import javax.inject.Inject

/**
 *
 */
class ParseJsonStepHandler @Inject constructor(

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

        val response = (request as StepRequest).copy(dto = stepDTO) // TODO: Remove type casts

        return response
    }

}
