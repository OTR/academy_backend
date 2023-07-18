package data.scraper.task.step.handler

import data.repository.StepRepositoryImpl
import data.scraper.task.step.request.StepRequest

import javax.inject.Inject

/**
 *
 */
class GetStepFromTableHandler @Inject constructor(
    private val repository: StepRepositoryImpl
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
