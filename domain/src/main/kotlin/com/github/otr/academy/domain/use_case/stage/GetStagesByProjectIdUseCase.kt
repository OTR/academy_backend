package com.github.otr.academy.domain.use_case.stage

import com.github.otr.academy.domain.model.Stage
import com.github.otr.academy.domain.repository.StageRepository

/**
 * Return all the `Stage` objects related to a `Project` with the given `ID`
 * `Project` HAS-A `Stage` ONE-TO-MANY relationship
 * Each `Stage` is unique (has unique `ID`) and belongs to a certain `Project`
 */
class GetStagesByProjectIdUseCase(
    private val repository: StageRepository
) {

    operator fun invoke(projectId: Int): List<Stage> {
        return repository.getStagesByProjectId(projectId)
    }

}
