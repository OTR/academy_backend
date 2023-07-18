package com.github.otr.academy.scraper.request_factory

import data.scraper.task.topic.request.TopicRequest
import data.scraper.task.topic.request.TopicRequestType

/**
 *
 */
object TopicRequestFactory {

    fun getBlankTopicRequest(
        topicId: Int,
    ) = TopicRequest(
        type = TopicRequestType(topicId),
        pathToCacheFile = null,
        isCacheExists = null,
        sourceData = null,
        dto = null,
        isRowExists = null,
        entityFromDB = null
    )

}
