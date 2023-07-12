package com.github.otr.academy.spring_backend.use_case.stage

import com.github.otr.academy.domain.model.Stage
import com.github.otr.academy.domain.repository.StageRepository

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
