package com.github.otr.academy.scraper.request_factory

import com.github.otr.academy.scraper.task.attempt.request.AttemptRequest
import com.github.otr.academy.scraper.task.attempt.request.AttemptRequestType

/**
 *
 */
internal object AttemptRequestFactory {

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
