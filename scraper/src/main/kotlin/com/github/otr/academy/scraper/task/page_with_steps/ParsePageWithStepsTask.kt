package data.scraper.task.page_with_steps

import data.mapper.blank.StepRequestFactory
import data.scraper.cache_handler.Cacheable
import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.core.task.BaseParseTask
import data.scraper.dto.step.StepDTO
import data.scraper.task.page_with_steps.handler.ParseJsonPageWithStepsHandler
import data.scraper.task.page_with_steps.request.PageWithStepsRequest

import di.ApplicationComponent
import di.DaggerApplicationComponent

/**
 *
 */
class ParsePageWithStepsTask(
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
