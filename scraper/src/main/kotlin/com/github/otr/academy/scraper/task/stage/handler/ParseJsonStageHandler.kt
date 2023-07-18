package com.github.otr.academy.scraper.task.stage.handler

import com.github.otr.academy.scraper.cache_handler.BaseCacheHandler
import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.dto.stage.StageContainerDTO
import com.github.otr.academy.scraper.dto.stage.StageDTO
import com.github.otr.academy.scraper.task.stage.request.StageRequest

import com.google.gson.Gson

import javax.inject.Inject

/**
 *
 */
internal class ParseJsonStageHandler @Inject constructor(
    // TODO: Replace Gson with P2I
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
        // TODO: Remove type cast
        val response = (request as StageRequest).copy(dto = stageDTO)

        return response
    }

}
