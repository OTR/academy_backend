package data.scraper.task.project

import data.scraper.core.task.BaseTask
import data.scraper.core.task.BaseLoadTask
import data.scraper.task.project.request.ProjectRequest

import kotlin.reflect.KClass


/**
 *
 */
class LoadProjectFromRemoteTask(request: ProjectRequest) : BaseLoadTask<ProjectRequest>(request) {

    override fun positiveResponse(): KClass<out BaseTask> {
        return ParseProjectTask::class
    }

}
