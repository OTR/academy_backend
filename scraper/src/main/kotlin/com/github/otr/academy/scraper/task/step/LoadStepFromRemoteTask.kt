package com.github.otr.academy.scraper.task.step

import com.github.otr.academy.scraper.core.task.BaseLoadTask
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.task.step.request.StepRequest

import kotlin.reflect.KClass


/**
 *
 */
internal class LoadStepFromRemoteTask(
    request: StepRequest
) : BaseLoadTask<StepRequest>(request) {

    override fun positiveResponse(): KClass<out BaseTask> {
        return ParseStepTask::class
    }

}
