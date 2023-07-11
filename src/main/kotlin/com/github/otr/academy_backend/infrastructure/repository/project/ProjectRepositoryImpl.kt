package com.github.otr.academy_backend.infrastructure.repository.project

import com.github.otr.academy_backend.domain.model.Project
import com.github.otr.academy_backend.domain.repository.ProjectRepository
import com.github.otr.academy_backend.infrastructure.database.dbo.ProjectEntity
import com.github.otr.academy_backend.infrastructure.mapper.project.ProjectMapper
import com.github.otr.academy_backend.infrastructure.repository.BaseRepository

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class ProjectRepositoryImpl(
    private val repository: JpaProjectRepository,
    private val mapper: ProjectMapper
): ProjectRepository, BaseRepository<Project, ProjectEntity>(repository, mapper)
