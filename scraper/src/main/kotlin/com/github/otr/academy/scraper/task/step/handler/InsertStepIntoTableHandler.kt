package com.github.otr.academy.scraper.task.step.handler

import com.github.otr.academy.domain.model.Step
import com.github.otr.academy.domain.repository.StepRepository
import com.github.otr.academy.scraper.dto.step.StepDTO
import com.github.otr.academy.scraper.mapper.GenericDtoMapper
import com.github.otr.academy.scraper.task.step.request.StepRequest

import javax.inject.Inject

/**
 *
 */
internal class InsertStepIntoTableHandler @Inject constructor(
    private val repository: StepRepository,
    private val mapper: GenericDtoMapper<Step, StepDTO>
) : BaseStepHandler() {

    override val handlerName: String = "INSERT step INTO steps table;"

    override fun canHandle(request: StepRequest): Boolean {
        return request.isRowExists == false && request.dto != null
    }

    override fun handle(request: StepRequest): StepRequest {
        val stepDTO = request.dto
        if (stepDTO != null) {
            val step: Step = mapper.mapDtoToDomain(stepDTO)
            repository.save(step)
        }

        return request
    }

}
