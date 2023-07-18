package data.scraper.task.topic

import data.scraper.cache_handler.Cacheable
import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.core.task.BaseParseTask
import data.scraper.task.topic.request.TopicRequest

import di.ApplicationComponent
import di.DaggerApplicationComponent

/**
 *
 */
class ParseTopicTask(
    private val request: TopicRequest
    ) : BaseParseTask<TopicRequest>(request) {

    private val component: ApplicationComponent = DaggerApplicationComponent.create()

    override val parseJsonHandler: Handler<Cacheable> = component.getParseJsonTopicHandler()

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain = buildChainOfHandlers()
        val response = chain(request)

        // TODO: check response
        if (response.dto != null) {
            return true to listOf(SaveTopicToDbTask(response))
        }
        return false to emptyList()
    }

}
