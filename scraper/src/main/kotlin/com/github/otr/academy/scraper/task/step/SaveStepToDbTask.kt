package data.scraper.task.step

import data.mapper.blank.AttemptReqestFactory
import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.task.attempt.LoadAttemptFromRemoteTask
import data.scraper.task.step.handler.GetStepFromTableHandler
import data.scraper.task.step.handler.InsertStepIntoTableHandler
import data.scraper.task.step.request.StepRequest

import di.ApplicationComponent
import di.DaggerApplicationComponent

/**
 *
 */
class SaveStepToDbTask(
    private val request: StepRequest
) : BaseTask {

    override val fullTaskName: String = "Save Step domain entity to Steps Table on database"

    private val component: ApplicationComponent = DaggerApplicationComponent.create()

    private val firstCheckExistence: GetStepFromTableHandler = component.getGetStepFromTableHandler()
    private val secondCheckExistence: GetStepFromTableHandler = component.getGetStepFromTableHandler()
    private val insertStepIntoTableHandler: InsertStepIntoTableHandler = component.getInsertStepIntoTableHandler()

    override fun buildChainOfHandlers(): Handler<StepRequest> {
        val chain = firstCheckExistence.setNext(
            insertStepIntoTableHandler.setNext(
                secondCheckExistence
            )
        )

        return chain
    }

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain: Handler<StepRequest> = buildChainOfHandlers()
        val response: StepRequest = chain(request)

        if (
            response.isRowExists == true
            && response.entityFromDB != null
            && response.dto != null
            && response.dto.id != null
        ) {
            val stepId: Int = response.dto.id
            return true to listOf(
                LoadAttemptFromRemoteTask(
                    AttemptReqestFactory.getBlankAttemptRequest(stepId)
                )
            )
        } else {
            throw RuntimeException("Check for prerequisites for this stage")
        }
    }

}
