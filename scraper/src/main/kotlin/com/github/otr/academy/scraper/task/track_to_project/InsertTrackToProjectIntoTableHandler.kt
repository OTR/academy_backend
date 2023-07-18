package data.scraper.task.track_to_project

import data.repository.parent_children.TrackToProjectRepositoryImpl
import data.scraper.task.track.handler.BaseTrackHandler
import data.scraper.task.track.request.TrackRequest

import javax.inject.Inject

class InsertTrackToProjectIntoTableHandler @Inject constructor(
    private val repository: TrackToProjectRepositoryImpl
) : BaseTrackHandler() {

    override val handlerName: String = "Insert Track To Project Into Database Table"

    override fun canHandle(request: TrackRequest): Boolean {
        return request.projectByLevel.isNotEmpty()
    }

    override fun handle(request: TrackRequest): TrackRequest {
        val trackToProjects: Pair<Int, List<Pair<String, Int>>> = request.type.id to request.projectByLevel
        repository.saveAll(trackToProjects)

        return request
    }

}
