package com.github.otr.academy.scraper.request_factory

import data.scraper.dto.stage.StageDTO
import data.scraper.task.stage.request.StageRequest
import data.scraper.task.stage.request.StageRequestType

/**
 *
 */
object StageRequestFactory {

    fun getBlankStageRequest(stageId: Int) = StageRequest(
        type = StageRequestType(stageId),
        pathToCacheFile = null,
        isCacheExists = null,
        sourceData = null,
        dto = null,
        listOfTopics = emptyList(),
        isRowExists = null,
        entityFromDB = null
    )

    fun getStageRequestWithDto(
        stageId: Int,
        stageDTO: StageDTO
    ) = StageRequest(
        type = StageRequestType(stageId),
        pathToCacheFile = null,
        isCacheExists = null,
        sourceData = null,
        dto = stageDTO,
        listOfTopics = emptyList(),
        isRowExists = null,
        entityFromDB = null
    )

}
