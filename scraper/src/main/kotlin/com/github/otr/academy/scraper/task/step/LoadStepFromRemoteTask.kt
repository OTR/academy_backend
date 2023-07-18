package data.scraper.task.step

import data.scraper.core.task.BaseTask
import data.scraper.core.task.BaseLoadTask
import data.scraper.task.step.request.StepRequest

import kotlin.reflect.KClass


/**
 *
 */
class LoadStepFromRemoteTask(request: StepRequest) : BaseLoadTask<StepRequest>(request) {

    override fun positiveResponse(): KClass<out BaseTask> {
        return ParseStepTask::class
    }

}
