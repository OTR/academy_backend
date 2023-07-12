package com.github.otr.academy.domain.use_case.track

import com.github.otr.academy.domain.response.ProjectsByLevel
import com.github.otr.academy.domain.repository.TrackRepository


/**
 *
 */
class GetProjectsByLevelByTrackIdUseCase(
    private val repository: TrackRepository
) {

    operator fun invoke(trackId: Int): ProjectsByLevel {
        return repository.getProjectsByLevelByTrackId(trackId)
    }

}
