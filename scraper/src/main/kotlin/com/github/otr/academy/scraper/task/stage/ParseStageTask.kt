package data.scraper.task.stage

import data.scraper.cache_handler.Cacheable
import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.core.task.BaseParseTask
import data.scraper.task.stage.request.StageRequest

import di.ApplicationComponent
import di.DaggerApplicationComponent

/**
 *
 */
class ParseStageTask(
    private val request: StageRequest
    ) : BaseParseTask<StageRequest>(request) {

    private val component: ApplicationComponent = DaggerApplicationComponent.create()

    override val parseJsonHandler: Handler<Cacheable> = component.getParseJsonStageHandler()

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain = buildChainOfHandlers()
        val response = chain(request)

        // TODO: check response
        if (response.dto != null) {
            return true to listOf(SaveStageToDbTask(response))
        }
        return false to emptyList()
    }

}
