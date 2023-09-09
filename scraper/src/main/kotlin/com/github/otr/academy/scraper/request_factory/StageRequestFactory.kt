package com.github.otr.academy.scraper.request_factory

import com.github.otr.academy.scraper.dto.stage.StageDTO
import com.github.otr.academy.scraper.task.stage.request.StageRequest
import com.github.otr.academy.scraper.task.stage.request.StageRequestType

/**
 *
 */
internal object StageRequestFactory {

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
