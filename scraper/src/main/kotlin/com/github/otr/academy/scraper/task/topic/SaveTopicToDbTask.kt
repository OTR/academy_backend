package data.scraper.task.topic

import data.mapper.blank.StepRequestFactory
import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.task.step.LoadStepFromRemoteTask
import data.scraper.task.topic.handler.GetTopicFromTableHandler
import data.scraper.task.topic.handler.InsertTopicIntoTableHandler
import data.scraper.task.topic.request.TopicRequest

import di.ApplicationComponent
import di.DaggerApplicationComponent

/**
 *
 */
class SaveTopicToDbTask(
    private val request: TopicRequest
) : BaseTask {

    override val fullTaskName: String = "Save Topic domain entity to Topics Table on database"

    private val component: ApplicationComponent = DaggerApplicationComponent.create()
    private val firstCheckExistence: GetTopicFromTableHandler = component.getTopicFromTableHandler()
    private val secondCheckExistence: GetTopicFromTableHandler = component.getTopicFromTableHandler()
    private val insertTopicIntoTableHandler: InsertTopicIntoTableHandler = component.getInsertTopicIntoTableHandler()

    override fun buildChainOfHandlers(): Handler<TopicRequest> {

        val chain = firstCheckExistence.setNext(
            insertTopicIntoTableHandler.setNext(
                secondCheckExistence
            )
        )

        return chain
    }

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain: Handler<TopicRequest> = buildChainOfHandlers()
        val response: TopicRequest = chain(request)

        if (
            response.isRowExists == true
            && response.entityFromDB != null
            && response.dto != null
            && response.dto.theory != null
        ) {
            val stepId: Int = (response.dto.theory)
            return true to listOf(
                LoadStepFromRemoteTask(
                    StepRequestFactory.getBlankStepRequest(stepId)
                )
            )
        } else {
            throw RuntimeException("Check for prerequisites for this stage")
        }
    }

}
