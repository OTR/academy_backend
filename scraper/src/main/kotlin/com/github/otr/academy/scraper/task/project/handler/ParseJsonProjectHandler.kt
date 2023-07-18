package com.github.otr.academy.scraper.task.project.handler

import com.github.otr.academy.scraper.cache_handler.BaseCacheHandler
import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.dto.project.ProjectContainerDTO
import com.github.otr.academy.scraper.dto.project.ProjectDTO
import com.github.otr.academy.scraper.task.project.request.ProjectRequest

import com.google.gson.Gson

import javax.inject.Inject

/**
 *
 */
internal class ParseJsonProjectHandler @Inject constructor(
    // TODO: Replace Gson with P2I
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
        // TODO: Remove type casts
        val response = (request as ProjectRequest).copy(dto = projectDTO)

        return response
    }

}
