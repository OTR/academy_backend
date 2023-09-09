package com.github.otr.academy.scraper.task.step.handler

import com.github.otr.academy.domain.model.Step
import com.github.otr.academy.domain.repository.StepRepository
import com.github.otr.academy.scraper.task.step.request.StepRequest

import javax.inject.Inject

/**
 *
 */
internal class GetStepFromTableHandler @Inject constructor(
    private val repository: StepRepository
): BaseStepHandler() {

    override val handlerName: String = "Try to SELECT Step FROM Steps table;"

    override fun canHandle(request: StepRequest): Boolean {
        return request.dto != null
                && request.isRowExists != true
    }

    override fun handle(request: StepRequest): StepRequest {
        val stageFromDb: Step? = repository.getById(request.type.id)
        val result = if (stageFromDb != null) {
            request.copy(
                isRowExists = true,
                entityFromDB = stageFromDb
            )
        } else {
            request.copy(
                isRowExists = false
            )
        }
        return result
    }

}
