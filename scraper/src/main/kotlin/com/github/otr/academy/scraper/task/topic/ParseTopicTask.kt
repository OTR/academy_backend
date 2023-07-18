package com.github.otr.academy.scraper.task.topic

import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.core.task.BaseParseTask
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.di.ApplicationComponent
import com.github.otr.academy.scraper.task.topic.request.TopicRequest

/**
 *
 */
internal class ParseTopicTask(
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
