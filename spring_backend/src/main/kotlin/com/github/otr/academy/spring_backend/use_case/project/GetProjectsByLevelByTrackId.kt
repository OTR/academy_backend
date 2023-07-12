package com.github.otr.academy.spring_backend.use_case.project

import com.github.otr.academy.domain.model.ProjectsByLevel
import com.github.otr.academy.domain.repository.TrackRepository

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
