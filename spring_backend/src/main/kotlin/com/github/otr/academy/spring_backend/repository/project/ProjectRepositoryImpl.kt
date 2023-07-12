package com.github.otr.academy.spring_backend.repository.project

import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.repository.ProjectRepository

import com.github.otr.academy.spring_backend.database.dbo.ProjectEntity
import com.github.otr.academy.spring_backend.mapper.ProjectMapper
import com.github.otr.academy.spring_backend.repository.BaseRepository

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class ProjectRepositoryImpl(
    private val repository: JpaProjectRepository,
    private val mapper: ProjectMapper
): ProjectRepository, BaseRepository<Project, ProjectEntity>(repository, mapper)
