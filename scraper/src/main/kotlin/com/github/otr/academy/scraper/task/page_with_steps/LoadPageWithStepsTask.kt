package com.github.otr.academy.scraper.task.page_with_steps

import com.github.otr.academy.scraper.task.page_with_steps.request.PageWithStepsRequest
import com.github.otr.academy.scraper.core.task.BaseLoadTask
import com.github.otr.academy.scraper.core.task.BaseTask

import kotlin.reflect.KClass


/**
 *
 */
internal class LoadPageWithStepsTask(
    request: PageWithStepsRequest
) : BaseLoadTask<PageWithStepsRequest>(request) {

    override fun positiveResponse(): KClass<out BaseTask> {
        return ParsePageWithStepsTask::class
    }

}
