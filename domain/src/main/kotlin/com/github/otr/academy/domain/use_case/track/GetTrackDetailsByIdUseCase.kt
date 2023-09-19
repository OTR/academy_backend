package com.github.otr.academy.domain.use_case.track

import com.github.otr.academy.domain.model.Track
import com.github.otr.academy.domain.repository.TrackRepository

/**
 * Return all the `Track` fields (details) by the given `Track` ID
 * if a `Track` with such `ID` exists, otherwise return `null`
 */
class GetTrackDetailsByIdUseCase(
    private val repository: TrackRepository
) {

    operator fun invoke(trackId: Int): Track? {
        return repository.getById(trackId)
    }

}
