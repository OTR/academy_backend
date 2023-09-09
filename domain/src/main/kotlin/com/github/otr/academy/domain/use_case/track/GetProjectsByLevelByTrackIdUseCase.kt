package com.github.otr.academy.domain.use_case.track

import com.github.otr.academy.domain.response.ProjectsByLevel
import com.github.otr.academy.domain.repository.TrackRepository

/**
 * Each `Track` has several `Project` objects establishing MANY-TO-MANY
 * relationship with extra row `level`
 * The same `Project` could be `easy` level for one `Track` and `medium` for
 * another `Track`
 */
class GetProjectsByLevelByTrackIdUseCase(
    private val repository: TrackRepository
) {

    operator fun invoke(trackId: Int): ProjectsByLevel {
        return repository.getProjectsByLevelByTrackId(trackId)
    }

}
