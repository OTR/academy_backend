package data.scraper.task.topic

import data.scraper.core.task.BaseTask
import data.scraper.core.task.BaseLoadTask
import data.scraper.task.topic.request.TopicRequest

import kotlin.reflect.KClass


/**
 *
 */
class LoadTopicFromRemoteTask(request: TopicRequest) : BaseLoadTask<TopicRequest>(request) {

    override fun positiveResponse(): KClass<out BaseTask> {
        return ParseTopicTask::class
    }

}
