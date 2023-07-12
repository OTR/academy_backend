package com.github.otr.academy.spring_details.database.jpa.repository.project

import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.repository.ProjectRepository

import com.github.otr.academy.spring_details.database.jpa.dbo.ProjectEntity
import com.github.otr.academy.spring_details.database.jpa.mapper.ProjectMapper
import com.github.otr.academy.spring_details.database.jpa.repository.BaseRepository

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class ProjectRepositoryImpl(
    private val repository: JpaProjectRepository,
    private val projectMapper: ProjectMapper
): ProjectRepository, BaseRepository<Project, ProjectEntity>(repository, projectMapper)
