package com.github.otr.academy_backend.use_case.project

import com.github.otr.academy_backend.domain.model.ProjectsByLevel
import com.github.otr.academy_backend.domain.repository.TrackRepository
import org.springframework.stereotype.Service

/**
 *
 */
@Service
class GetProjectsByLevelByTrackIdUseCase(
    private val repository: TrackRepository
) {

    operator fun invoke(trackId: Int): ProjectsByLevel {
        return repository.getProjectsByLevelByTrackId(trackId)
    }

}
