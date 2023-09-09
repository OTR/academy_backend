package com.github.otr.academy.scraper.task.topic

import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.di.ApplicationComponent
import com.github.otr.academy.scraper.request_factory.StepRequestFactory
import com.github.otr.academy.scraper.task.step.LoadStepFromRemoteTask
import com.github.otr.academy.scraper.task.topic.handler.GetTopicFromTableHandler
import com.github.otr.academy.scraper.task.topic.handler.InsertTopicIntoTableHandler
import com.github.otr.academy.scraper.task.topic.request.TopicRequest

/**
 *
 */
internal class SaveTopicToDbTask(
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
