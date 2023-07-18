package data.scraper.task.track_to_project

import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.task.track.request.TrackRequest

import di.ApplicationComponent
import di.DaggerApplicationComponent

/**
 *
 */
class SaveTrackToProjectTask(val request: TrackRequest) : BaseTask {

    override val fullTaskName: String = "Create a table to assign a projects to track"

    private val component: ApplicationComponent = DaggerApplicationComponent.create()
    private val insertTrackToProjectIntoTableHandler: InsertTrackToProjectIntoTableHandler = component.getInsertTrackToProjectIntoTableHandler()

    override fun buildChainOfHandlers(): Handler<TrackRequest> {
        val chain = insertTrackToProjectIntoTableHandler

        return chain
    }

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain: Handler<TrackRequest> = buildChainOfHandlers()
        val response: TrackRequest = chain(request)

        return false to emptyList()
    }

}
