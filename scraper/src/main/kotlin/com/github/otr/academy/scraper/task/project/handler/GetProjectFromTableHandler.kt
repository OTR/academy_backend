package data.scraper.task.project.handler

import data.scraper.task.project.request.ProjectRequest
import domain.repository.GenericRepository

import javax.inject.Inject

/**
 *
 */
class GetProjectFromTableHandler @Inject constructor(
    private val repository: GenericRepository<Project>
) : BaseProjectHandler() {

    override val handlerName: String = "SELECT PROJECT FROM PROJECT TABLE"

    override fun canHandle(request: ProjectRequest): Boolean {
        return request.dto != null
                && request.isRowExists != true
    }

    override fun handle(request: ProjectRequest): ProjectRequest {

        val projectFromDb: Project? = repository.getById(request.type.id)
        val result = if (projectFromDb != null) {
            request.copy(
                isRowExists = true,
                entityFromDB = projectFromDb
            )
        } else {
            request.copy(
                isRowExists = false
            )
        }
        return result
    }

}
