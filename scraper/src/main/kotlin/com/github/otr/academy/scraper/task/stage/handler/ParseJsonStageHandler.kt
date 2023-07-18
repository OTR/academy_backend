package data.scraper.task.stage.handler

import com.google.gson.Gson
import data.scraper.cache_handler.BaseCacheHandler
import data.scraper.dto.stage.StageContainerDTO
import data.scraper.dto.stage.StageDTO
import data.scraper.cache_handler.Cacheable
import data.scraper.task.stage.request.StageRequest

import javax.inject.Inject

/**
 *
 */
class ParseJsonStageHandler @Inject constructor(

): BaseCacheHandler() {

    override val handlerName: String = "Parse JSON to Stage DTO handler"

    override fun canHandle(request: Cacheable): Boolean {
        return request.sourceData != null
    }

    override fun handle(request: Cacheable): Cacheable {
        val rawJson: String = request.sourceData
            ?: throw IllegalArgumentException("Source data should not be null")

        // TODO: Remove concrete realization of Gson parser DI
        val stageContainerDTO: StageContainerDTO = Gson()
            .fromJson(rawJson, StageContainerDTO::class.java)

        val stageDTO: StageDTO = stageContainerDTO.stages.first()

        val response = (request as StageRequest).copy(dto = stageDTO)

        return response
    }

}
