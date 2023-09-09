package com.github.otr.academy.scraper.task.project.handler

import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.repository.GenericRepository
import com.github.otr.academy.scraper.dto.project.ProjectDTO
import com.github.otr.academy.scraper.mapper.GenericDtoMapper
import com.github.otr.academy.scraper.task.project.request.ProjectRequest

import javax.inject.Inject

/**
 *
 */
internal class InsertProjectIntoTableHandler @Inject constructor(
    private val repository: GenericRepository<Project>,
    private val mapper: GenericDtoMapper<Project, ProjectDTO>
): BaseProjectHandler() {

    override val handlerName: String = "INSERT Project INTO projects table;"

    override fun canHandle(request: ProjectRequest): Boolean {
        return request.isRowExists == false && request.dto != null
    }

    override fun handle(request: ProjectRequest): ProjectRequest {

        val projectDTO = request.dto
        if (projectDTO != null) {
            val project: Project = mapper.mapDtoToDomain(projectDTO)
            repository.save(project)
        }

        return request
    }

}
