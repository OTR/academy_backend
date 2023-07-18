package data.scraper.task.track.handler

import data.scraper.task.track.request.TrackRequest
import domain.repository.GenericRepository

import javax.inject.Inject

/**
 *
 */
class GetTrackFromTableHandler @Inject constructor(
    private val repository: GenericRepository<Track>
) : BaseTrackHandler() {

    override val handlerName: String = "SELECT Track by Given ID from database"

    override fun canHandle(request: TrackRequest): Boolean {
        return request.dto != null
                && request.isRowExists != true
    }

    override fun handle(request: TrackRequest): TrackRequest {
        val trackFromDb: Track? = repository.getById(request.type.id)
        val result = if (trackFromDb != null) {
            request.copy(
                isRowExists = true,
                entityFromDB = trackFromDb
            )
        } else {
            request.copy(
                isRowExists = false
            )
        }
        return result
    }

}
