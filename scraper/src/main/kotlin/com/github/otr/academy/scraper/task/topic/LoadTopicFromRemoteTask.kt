package com.github.otr.academy.scraper.task.topic

import com.github.otr.academy.scraper.core.task.BaseLoadTask
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.task.topic.request.TopicRequest

import kotlin.reflect.KClass

/**
 *
 */
internal class LoadTopicFromRemoteTask(
    request: TopicRequest
) : BaseLoadTask<TopicRequest>(request) {

    override fun positiveResponse(): KClass<out BaseTask> {
        return ParseTopicTask::class
    }

}
