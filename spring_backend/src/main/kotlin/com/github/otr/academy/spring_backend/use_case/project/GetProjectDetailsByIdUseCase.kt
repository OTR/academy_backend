package com.github.otr.academy.spring_backend.use_case.project

import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.repository.ProjectRepository

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
