package data.scraper.task.track

import data.mapper.blank.ProjectRequestFactory
import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.datasource.ALPHA_PROJECTS
import data.scraper.task.project.LoadProjectFromRemoteTask
import data.scraper.task.track.handler.GetTrackFromTableHandler
import data.scraper.task.track.handler.InsertTrackIntoTableHandler
import data.scraper.task.track.request.TrackRequest
import data.scraper.task.track_to_project.SaveTrackToProjectTask

import di.ApplicationComponent
import di.DaggerApplicationComponent

/**
 *
 */
class SaveTrackToDbTask(val request: TrackRequest) : BaseTask {

    override val fullTaskName: String = "INSERT Track ${request.type.id} as Row INTO tracks database"

    private val component: ApplicationComponent = DaggerApplicationComponent.create()
    private val firstCheckExistence: GetTrackFromTableHandler = component.getTrackFromTableHandler()
    private val secondCheckExistence: GetTrackFromTableHandler = component.getTrackFromTableHandler()
    private val insertTrackIntoTableHandler: InsertTrackIntoTableHandler = component.getInsertTrackIntoTableHandler()

    override fun buildChainOfHandlers(): Handler<TrackRequest> {

        val chain = firstCheckExistence.setNext(
            insertTrackIntoTableHandler.setNext(
                secondCheckExistence
            )
        )

        return chain
    }

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain: Handler<TrackRequest> = buildChainOfHandlers()
        val response: TrackRequest = chain(request)

        if (
            response.isRowExists == true
            && response.entityFromDB != null
            && response.dto != null
            && response.dto.projects.isNotEmpty()
            && response.dto.projectsByLevel != null
        ) {
            val projectsByLevel = response.dto.projectsByLevel
            val betaProjects = response.dto.betaProjects
            val capstoneProjects = response.dto.capstoneProjects

            val projects = response.dto.projects +
                    response.dto.betaProjects +
                    ALPHA_PROJECTS

            val allProjectsByLevel: List<Pair<String, Int>> = buildList {
                addAll(projectsByLevel.easy?.map { "easy" to it } ?: emptyList())
                addAll(projectsByLevel.medium?.map { "medium" to it } ?: emptyList())
                addAll(projectsByLevel.hard?.map { "hard" to it } ?: emptyList())
                addAll(projectsByLevel.nightmare?.map { "challenging" to it } ?: emptyList())
                addAll(betaProjects.map { "beta" to it })
                addAll(capstoneProjects.map { "capstone" to it })
            }

            val assertProjectsToTrackTask = SaveTrackToProjectTask(
                response.copy(projectByLevel = allProjectsByLevel)
            )

            val loadProjectsTasks =  projects.map {
                LoadProjectFromRemoteTask(
                    ProjectRequestFactory.getBlankProjectRequest(it)
                )
            }

            return true to listOf(assertProjectsToTrackTask) + loadProjectsTasks
        }
        return false to emptyList()
    }

}
