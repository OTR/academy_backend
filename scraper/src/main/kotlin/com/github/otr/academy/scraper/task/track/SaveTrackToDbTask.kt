package com.github.otr.academy.scraper.task.track

import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.datasource.ALPHA_PROJECTS
import com.github.otr.academy.scraper.di.ApplicationComponent
import com.github.otr.academy.scraper.request_factory.ProjectRequestFactory
import com.github.otr.academy.scraper.task.project.LoadProjectFromRemoteTask
import com.github.otr.academy.scraper.task.track.handler.GetTrackFromTableHandler
import com.github.otr.academy.scraper.task.track.handler.InsertTrackIntoTableHandler
import com.github.otr.academy.scraper.task.track.request.TrackRequest
import com.github.otr.academy.scraper.task.track_to_project.SaveTrackToProjectTask

/**
 *
 */
internal class SaveTrackToDbTask(val request: TrackRequest) : BaseTask {

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
