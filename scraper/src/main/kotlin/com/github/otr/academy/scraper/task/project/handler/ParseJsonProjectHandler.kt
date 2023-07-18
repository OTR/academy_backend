package data.scraper.task.project.handler

import com.google.gson.Gson

import data.scraper.cache_handler.BaseCacheHandler
import data.scraper.dto.project.ProjectContainerDTO
import data.scraper.dto.project.ProjectDTO
import data.scraper.cache_handler.Cacheable
import data.scraper.task.project.request.ProjectRequest

import javax.inject.Inject

/**
 *
 */
class ParseJsonProjectHandler @Inject constructor(

) : BaseCacheHandler() {

    override val handlerName: String = "Parse JSON to Project domain entity"

    override fun canHandle(request: Cacheable): Boolean {
        return request.sourceData != null
    }

    override fun handle(request: Cacheable): Cacheable {
        val rawJson: String = request.sourceData
            ?: throw IllegalArgumentException("Source data should not be null")

        // TODO: Inject Concrete realization of JSON Parser with DI
        val projectContainerDTO: ProjectContainerDTO = Gson()
            .fromJson(rawJson, ProjectContainerDTO::class.java)

        val projectDTO: ProjectDTO = projectContainerDTO.projects.first()

        val response = (request as ProjectRequest).copy(dto = projectDTO) // TODO: Remove type casts

        return response
    }

}
