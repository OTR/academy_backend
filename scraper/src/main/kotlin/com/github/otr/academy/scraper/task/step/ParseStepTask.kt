package com.github.otr.academy.scraper.task.step

import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.core.task.BaseParseTask
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.di.ApplicationComponent
import com.github.otr.academy.scraper.task.step.request.StepRequest

/**
 *
 */
internal class ParseStepTask(
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
