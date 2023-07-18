package data.scraper.task.page_with_steps.handler

import com.google.gson.Gson

import data.scraper.cache_handler.BaseCacheHandler
import data.scraper.dto.step.StepContainerDTO
import data.scraper.dto.step.StepDTO
import data.scraper.task.page_with_steps.request.PageWithStepsRequest
import data.scraper.cache_handler.Cacheable

import javax.inject.Inject

/**
 *
 */
class ParseJsonPageWithStepsHandler @Inject constructor(

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

        val response = (request as PageWithStepsRequest).copy(listOfStepDTO = listOfStepDTO)

        return response
    }

}
