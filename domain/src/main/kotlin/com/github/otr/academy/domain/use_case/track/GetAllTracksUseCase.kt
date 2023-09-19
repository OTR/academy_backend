package com.github.otr.academy.domain.use_case.track

import com.github.otr.academy.domain.model.Track
import com.github.otr.academy.domain.repository.TrackRepository

/**
 * Return all existing `Track` objects?
 */
class GetAllTracksUseCase(
    private val repository: TrackRepository
) {

    operator fun invoke(): List<Track> {
        return repository.getAll()
    }

}
