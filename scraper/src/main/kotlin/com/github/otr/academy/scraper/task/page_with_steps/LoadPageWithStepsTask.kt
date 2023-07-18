package data.scraper.task.page_with_steps

import data.scraper.core.task.BaseTask
import data.scraper.task.page_with_steps.request.PageWithStepsRequest
import data.scraper.core.task.BaseLoadTask

import kotlin.reflect.KClass


/**
 *
 */
class LoadPageWithStepsTask(
    request: PageWithStepsRequest
) : BaseLoadTask<PageWithStepsRequest>(request) {

    override fun positiveResponse(): KClass<out BaseTask> {
        return ParsePageWithStepsTask::class
    }

}
