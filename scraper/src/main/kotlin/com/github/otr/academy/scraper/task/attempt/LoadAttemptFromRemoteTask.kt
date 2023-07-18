package com.github.otr.academy.scraper.task.attempt

import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.core.task.BaseLoadTask
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.di.ApplicationComponent
import com.github.otr.academy.scraper.task.attempt.request.AttemptRequest


import kotlin.reflect.KClass

/**
 *
 */
internal class LoadAttemptFromRemoteTask(request: AttemptRequest) : BaseLoadTask<AttemptRequest>(request) {

    private val component: ApplicationComponent = DaggerApplicationComponent.create()

    override val loadSourceJsonHandler: Handler<Cacheable> = component.getLoadAttemptHandler()

    override fun positiveResponse(): KClass<out BaseTask> {
        return ParseAttemptTask::class
    }

}
