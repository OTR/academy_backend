package data.scraper.task.attempt

import data.scraper.cache_handler.Cacheable
import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.core.task.BaseLoadTask
import data.scraper.task.attempt.request.AttemptRequest

import di.ApplicationComponent
import di.DaggerApplicationComponent

import kotlin.reflect.KClass

/**
 *
 */
class LoadAttemptFromRemoteTask(request: AttemptRequest) : BaseLoadTask<AttemptRequest>(request) {

    private val component: ApplicationComponent = DaggerApplicationComponent.create()

    override val loadSourceJsonHandler: Handler<Cacheable> = component.getLoadAttemptHandler()

    override fun positiveResponse(): KClass<out BaseTask> {
        return ParseAttemptTask::class
    }

}
