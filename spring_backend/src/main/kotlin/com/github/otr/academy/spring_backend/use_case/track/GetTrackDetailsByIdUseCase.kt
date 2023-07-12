package com.github.otr.academy.spring_backend.use_case.track

import com.github.otr.academy.domain.model.Track
import com.github.otr.academy.domain.repository.TrackRepository

import org.springframework.stereotype.Service

/**
 *
 */
@Service
class GetTrackDetailsByIdUseCase(
    private val repository: TrackRepository
) {

    operator fun invoke(trackId: Int): Track {
        return repository.getById(trackId)
    }

}
