package com.github.otr.academy_backend.use_case.project

import com.github.otr.academy_backend.domain.model.Project
import com.github.otr.academy_backend.domain.repository.ProjectRepository

import org.springframework.stereotype.Service

/**
 *
 */
@Service
class GetProjectDetailsByIdUseCase(
    private val repository: ProjectRepository
) {

    operator fun invoke(projectId: Int): Project {
        return repository.getById(projectId)
    }

}
