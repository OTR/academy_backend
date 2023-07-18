package data.scraper.task.stage

import data.scraper.core.task.BaseTask
import data.scraper.core.task.BaseLoadTask
import data.scraper.task.stage.request.StageRequest

import kotlin.reflect.KClass

/**
 *
 */
class LoadStageFromRemoteTask(request: StageRequest) : BaseLoadTask<StageRequest>(request) {

    override fun positiveResponse(): KClass<out BaseTask> {
        return ParseStageTask::class
    }

}
