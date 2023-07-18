package data.scraper.task.project

import data.mapper.blank.StageRequestFactory
import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.task.project.request.ProjectRequest
import data.scraper.task.project.handler.GetProjectFromTableHandler
import data.scraper.task.project.handler.InsertProjectIntoTableHandler
import data.scraper.task.stage.LoadStageFromRemoteTask

import di.ApplicationComponent
import di.DaggerApplicationComponent

/**
 *
 */
class SaveProjectToDbTask(
    private val request: ProjectRequest
) : BaseTask {

    override val fullTaskName: String = "Save Project domain entity to Projects Table on database"

    private val component: ApplicationComponent = DaggerApplicationComponent.create()
    private val firstCheckExistence: GetProjectFromTableHandler = component.getProjectFromTableHandler()
    private val secondCheckExistence: GetProjectFromTableHandler = component.getProjectFromTableHandler()
    private val insertProjectIntoTableHandler: InsertProjectIntoTableHandler =
        component.getInsertProjectIntoTableHandler()

    override fun buildChainOfHandlers(): Handler<ProjectRequest> {
        val chain = firstCheckExistence.setNext(
            insertProjectIntoTableHandler.setNext(
                secondCheckExistence
            )
        )

        return chain
    }

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain: Handler<ProjectRequest> = buildChainOfHandlers()
        val response: ProjectRequest = chain(request)

        if (
            response.isRowExists == true
            && response.entityFromDB != null
            && response.dto != null
            && response.dto.stagesIds.isNotEmpty()
        ) {
            val stageIds = response.dto.stagesIds
            // FIXME: It's trying to load projects that already was loaded
            return true to stageIds
                .map { stageId: Int ->
                    LoadStageFromRemoteTask(
                        StageRequestFactory.getBlankStageRequest(stageId)
                    )
                }
        }
        return false to emptyList()
    }

}
