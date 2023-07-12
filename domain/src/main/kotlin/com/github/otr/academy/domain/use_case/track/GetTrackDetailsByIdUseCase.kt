package com.github.otr.academy.domain.use_case.track

import com.github.otr.academy.domain.model.Track
import com.github.otr.academy.domain.repository.TrackRepository

/**
 *
 */
class GetTrackDetailsByIdUseCase(
    private val repository: TrackRepository
) {

    operator fun invoke(trackId: Int): Track {
        return repository.getById(trackId)
    }

}
