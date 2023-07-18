package data.scraper.task.step.handler

import data.mapper.dto_to_domain.GenericDtoToDomainMapper
import data.scraper.dto.step.StepDTO
import data.scraper.task.step.request.StepRequest
import domain.repository.StepRepository

import javax.inject.Inject

/**
 *
 */
class InsertStepIntoTableHandler @Inject constructor(
    private val repository: StepRepository,
    private val mapper: GenericDtoToDomainMapper<Step, StepDTO>
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
