package com.github.otr.academy.domain.use_case.stage

import com.github.otr.academy.domain.model.Stage
import com.github.otr.academy.domain.repository.StageRepository

/**
 *
 */
class GetStagesByProjectIdUseCase(
    private val repository: StageRepository
) {

    operator fun invoke(projectId: Int): List<Stage> {
        return repository.getStagesByProjectId(projectId)
    }

}
