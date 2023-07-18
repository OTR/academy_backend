package com.github.otr.academy.scraper.task.project

import com.github.otr.academy.scraper.core.task.BaseLoadTask
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.task.project.request.ProjectRequest

import kotlin.reflect.KClass


/**
 *
 */
internal class LoadProjectFromRemoteTask(
    request: ProjectRequest
) : BaseLoadTask<ProjectRequest>(request) {

    override fun positiveResponse(): KClass<out BaseTask> {
        return ParseProjectTask::class
    }

}
