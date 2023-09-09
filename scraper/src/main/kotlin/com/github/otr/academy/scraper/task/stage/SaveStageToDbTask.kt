package com.github.otr.academy.scraper.task.stage

import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.di.ApplicationComponent
import com.github.otr.academy.scraper.request_factory.TopicRequestFactory
import com.github.otr.academy.scraper.task.stage.handler.GetStageFromTableHandler
import com.github.otr.academy.scraper.task.stage.handler.InsertStageIntoTableHandler
import com.github.otr.academy.scraper.task.stage.request.StageRequest
import com.github.otr.academy.scraper.task.topic.LoadTopicFromRemoteTask

/**
 *
 */
internal class SaveStageToDbTask(
    private val request: StageRequest
) : BaseTask {

    override val fullTaskName: String = "Save Stage domain entity to Stages Table on database"

    private val component: ApplicationComponent = DaggerApplicationComponent.create()
    private val firstCheckExistence: GetStageFromTableHandler = component.getStageFromTableHandler()
    private val secondCheckExistence: GetStageFromTableHandler = component.getStageFromTableHandler()
    private val insertStageIntoTableHandler: InsertStageIntoTableHandler = component.getInsertStageIntoTableHandler()

    override fun buildChainOfHandlers(): Handler<StageRequest> {
        val chain = firstCheckExistence.setNext(
            insertStageIntoTableHandler.setNext(
                secondCheckExistence
            )
        )

        return chain
    }

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain: Handler<StageRequest> = buildChainOfHandlers()
        val response: StageRequest = chain(request)

        if (
            response.isRowExists == true
            && response.entityFromDB != null
            && response.dto != null
            && response.dto.allPrerequisites.isNotEmpty()
        ) {
            val topicsIds: Set<Int> = (response.dto.allPrerequisites + response.dto.prerequisites).toSet()
            return true to topicsIds
                .map { topicId: Int ->
                    LoadTopicFromRemoteTask(
                        TopicRequestFactory.getBlankTopicRequest(topicId)
                    )
                }
        } else {
            throw RuntimeException("Check for prerequisites for this stage")
        }
    }

}
