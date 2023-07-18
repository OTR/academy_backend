package data.scraper.task.stage

import data.mapper.blank.TopicRequestFactory
import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.task.stage.handler.GetStageFromTableHandler
import data.scraper.task.stage.handler.InsertStageIntoTableHandler
import data.scraper.task.stage.request.StageRequest
import data.scraper.task.topic.LoadTopicFromRemoteTask

import di.ApplicationComponent
import di.DaggerApplicationComponent

/**
 *
 */
class SaveStageToDbTask(
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
