package com.github.otr.academy_backend.use_case.stage

import com.github.otr.academy_backend.domain.model.Stage
import com.github.otr.academy_backend.domain.repository.StageRepository

import org.springframework.stereotype.Service

/**
 *
 */
@Service
class GetStagesByProjectIdUseCase(
    private val repository: StageRepository
) {

    operator fun invoke(projectId: Int): List<Stage> {
        return repository.getStagesByProjectId(projectId)
    }

}
