package com.github.otr.academy.scraper.task.track.handler

import com.github.otr.academy.domain.model.Track
import com.github.otr.academy.domain.repository.GenericRepository
import com.github.otr.academy.scraper.dto.track.TrackDTO
import com.github.otr.academy.scraper.mapper.GenericDtoMapper
import com.github.otr.academy.scraper.task.track.request.TrackRequest

import javax.inject.Inject

/**
 *
 */
internal class InsertTrackIntoTableHandler @Inject constructor(
    private val repository: GenericRepository<Track>,
    private val mapper: GenericDtoMapper<Track, TrackDTO>
) : BaseTrackHandler() {

    override val handlerName: String = "INSERT Track INTO database"

    override fun canHandle(request: TrackRequest): Boolean {
        return request.isRowExists == false
                && request.dto != null
    }

    override fun handle(request: TrackRequest): TrackRequest {
        val trackDTO = request.dto
        if (trackDTO != null) {
            val track: Track = mapper.mapDtoToDomain(trackDTO)
            repository.save(track)
        }

        return request
    }

}
