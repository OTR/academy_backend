package com.github.otr.academy.scraper.task.page_with_steps

import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.core.task.BaseParseTask
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.di.ApplicationComponent
import com.github.otr.academy.scraper.dto.step.StepDTO
import com.github.otr.academy.scraper.request_factory.StepRequestFactory
import com.github.otr.academy.scraper.task.page_with_steps.handler.ParseJsonPageWithStepsHandler
import com.github.otr.academy.scraper.task.page_with_steps.request.PageWithStepsRequest

/**
 *
 */
internal class ParsePageWithStepsTask(
    private val request: PageWithStepsRequest
) : BaseParseTask<PageWithStepsRequest>(request) {

    private val component: ApplicationComponent = DaggerApplicationComponent.create()
    private val parseJsonPageWithStepsHandler: ParseJsonPageWithStepsHandler =
        component.getParseJsonPageWithStepsHandler()

    override val parseJsonHandler: Handler<Cacheable> = parseJsonPageWithStepsHandler

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain = buildChainOfHandlers()
        val response = chain(request)

        // TODO: check response
        val listOfSteps = response.listOfStepDTO
        if (listOfSteps.isNotEmpty()) {
            return true to listOfSteps.map {dto: StepDTO ->
                val stepId: Int? = dto.id
                if (stepId != null) {
                    SaveStepToCacheTask(
                        StepRequestFactory.getStepRequestWithDto(stepId, dto)
                    )
                } else {
                    throw IllegalArgumentException("DTO id field should not be null")
                }

            }
        }
        return false to emptyList()
    }

}
