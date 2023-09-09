package com.github.otr.academy.scraper.request_factory

import com.github.otr.academy.scraper.dto.step.StepContainerDTO
import com.github.otr.academy.scraper.dto.step.StepDTO
import com.github.otr.academy.scraper.task.step.request.StepRequest
import com.github.otr.academy.scraper.task.step.request.StepRequestType

import com.google.gson.Gson

/**
 * TODO: Replace Gson with P2I
 */
internal object StepRequestFactory {

    fun getBlankStepRequest(
        stepId: Int,
    ) = StepRequest(
        type = StepRequestType(stepId),
        pathToCacheFile = null,
        isCacheExists = null,
        sourceData = null,
        isRowExists = null,
        dto = null,
        entityFromDB = null
    )

    fun getStepRequestWithDto(stepId: Int, stepDTO: StepDTO) : StepRequest {

        // TODO: Replace concrete realization of Gson with abstract JSON Parser
        val sourceData: String = Gson().toJson(
            StepContainerDTO(steps = arrayListOf(stepDTO)),
            StepContainerDTO::class.java
        )

        return StepRequest(
            type = StepRequestType(stepId),
            pathToCacheFile =null,
            sourceData = sourceData,
            isCacheExists = null,
            isRowExists = null,
            dto = stepDTO,
            entityFromDB = null
        )
    }

}
