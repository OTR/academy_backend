package com.github.otr.academy.scraper.task.stage.deprecated.handler

import com.github.otr.academy.scraper.cache_handler.BaseCacheHandler
import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.dto.stage.StageContainerDTO
import com.github.otr.academy.scraper.dto.stage.StageDTO
import com.github.otr.academy.scraper.task.stage.deprecated.request.StagesForProjectRequest

import com.google.gson.Gson

import javax.inject.Inject

/**
 *
 */
internal class ParseJsonStagesForProjectHandler @Inject constructor(
    // TODO: replace Gson with P2I
): BaseCacheHandler() {

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
