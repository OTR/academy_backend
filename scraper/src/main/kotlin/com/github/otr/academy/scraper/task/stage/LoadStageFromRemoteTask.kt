package com.github.otr.academy.scraper.task.stage

import com.github.otr.academy.scraper.core.task.BaseLoadTask
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.task.stage.request.StageRequest

import kotlin.reflect.KClass

/**
 *
 */
internal class LoadStageFromRemoteTask(request: StageRequest) : BaseLoadTask<StageRequest>(request) {

    override fun positiveResponse(): KClass<out BaseTask> {
        return ParseStageTask::class
    }

}
