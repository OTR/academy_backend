package data.scraper.task.step

import data.scraper.cache_handler.Cacheable
import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.core.task.BaseParseTask
import data.scraper.task.step.request.StepRequest

import di.ApplicationComponent
import di.DaggerApplicationComponent

/**
 *
 */
class ParseStepTask(
    private val request: StepRequest
    ) : BaseParseTask<StepRequest>(request) {

    private val component: ApplicationComponent = DaggerApplicationComponent.create()

    override val parseJsonHandler: Handler<Cacheable> = component.getParseJsonStepHandler()

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain = buildChainOfHandlers()
        val response = chain(request)

        // TODO: check response
        if (response.dto != null) {
            return true to listOf(SaveStepToDbTask(response))
        }
        return false to emptyList()
    }

}
