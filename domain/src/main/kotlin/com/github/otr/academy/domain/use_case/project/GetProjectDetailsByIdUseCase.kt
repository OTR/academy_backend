package com.github.otr.academy.domain.use_case.project

import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.repository.ProjectRepository

/**
 * Return all the fields (details) of a `Project` with the given `ID`
 * if `Project` with such `ID` exists otherwise `null`
 */
class GetProjectDetailsByIdUseCase(
    private val repository: ProjectRepository
) {

    operator fun invoke(projectId: Int): Project? {
        return repository.getById(projectId)
    }

}
