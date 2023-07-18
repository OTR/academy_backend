package com.github.otr.academy.scraper.task.track.handler

import com.github.otr.academy.domain.model.Track
import com.github.otr.academy.domain.repository.GenericRepository
import com.github.otr.academy.scraper.task.track.request.TrackRequest

import javax.inject.Inject

/**
 *
 */
internal class GetTrackFromTableHandler @Inject constructor(
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
