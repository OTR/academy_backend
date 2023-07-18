package com.github.otr.academy.scraper.task.project

import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.core.task.BaseParseTask
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.di.ApplicationComponent
import com.github.otr.academy.scraper.task.project.request.ProjectRequest

/**
 *
 */
internal class ParseProjectTask(
    private val request: ProjectRequest
) : BaseParseTask<ProjectRequest>(request) {

    private val component: ApplicationComponent = DaggerApplicationComponent.create()

    override val parseJsonHandler: Handler<Cacheable> = component.getParseJsonProjectHandler()

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain = buildChainOfHandlers()
        val response: ProjectRequest = chain(request)

        // TODO Check response
        if (response.dto != null) {
            return true to listOf(SaveProjectToDbTask(response))
        }
        return false to emptyList()
    }

    fun getResponse(): ProjectRequest {
        val chain = buildChainOfHandlers()
        val response: ProjectRequest = chain(request)

        if (response.dto != null) {
            return response
        } else {
            throw IllegalArgumentException("Project DTO is null")
        }
    }

}
