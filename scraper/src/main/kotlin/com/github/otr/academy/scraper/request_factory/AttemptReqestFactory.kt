package com.github.otr.academy.scraper.request_factory

import data.scraper.task.attempt.request.AttemptRequest
import data.scraper.task.attempt.request.AttemptRequestType

/**
 *
 */
object AttemptReqestFactory {

    fun getBlankAttemptRequest(
        stepId: Int,
    ) = AttemptRequest(
        type = AttemptRequestType(stepId),
        pathToCacheFile = null,
        isCacheExists = null,
        sourceData = null,
        isRowExists = null,
        dto = null,
        entityFromDB = null
    )

}
