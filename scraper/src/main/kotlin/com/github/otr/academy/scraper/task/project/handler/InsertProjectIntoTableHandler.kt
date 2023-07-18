package data.scraper.task.project.handler

import data.mapper.dto_to_domain.GenericDtoToDomainMapper
import data.scraper.dto.project.ProjectDTO
import data.scraper.task.project.request.ProjectRequest
import domain.repository.GenericRepository

import javax.inject.Inject

/**
 *
 */
class InsertProjectIntoTableHandler @Inject constructor(
    private val repository: GenericRepository<Project>,
    private val mapper: GenericDtoToDomainMapper<Project, ProjectDTO>
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
