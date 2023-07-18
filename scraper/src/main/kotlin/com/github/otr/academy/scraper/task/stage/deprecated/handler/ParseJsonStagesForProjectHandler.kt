package data.scraper.task.stage.deprecated.handler

import com.google.gson.Gson

import data.scraper.cache_handler.BaseCacheHandler
import data.scraper.dto.stage.StageDTO
import data.scraper.dto.stage.StageContainerDTO
import data.scraper.cache_handler.Cacheable
import data.scraper.task.stage.deprecated.request.StagesForProjectRequest

/**
 *
 */
object ParseJsonStagesForProjectHandler: BaseCacheHandler() {

    override val handlerName: String = "Parse Stages for project"

    override fun canHandle(request: Cacheable): Boolean {
        return request.sourceData != null
    }

    override fun handle(request: Cacheable): Cacheable {
        val rawJson: String = request.sourceData
            ?: throw IllegalArgumentException("Source data should not be null")

        val stagesForProjectContainerDTO: StageContainerDTO = Gson()
            .fromJson(rawJson, StageContainerDTO::class.java)

        val stagesDTO: List<StageDTO> = stagesForProjectContainerDTO.stages

        // TODO: Remove type casts
        val response = (request as StagesForProjectRequest).copy(stagesDTO = stagesDTO)

        return response
    }

}
