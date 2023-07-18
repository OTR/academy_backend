package data.scraper.task.project

import data.scraper.cache_handler.Cacheable
import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.core.task.BaseParseTask
import data.scraper.task.project.request.ProjectRequest

import di.ApplicationComponent
import di.DaggerApplicationComponent

/**
 *
 */
class ParseProjectTask(
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
