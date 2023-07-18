package com.github.otr.academy.scraper.request_factory

import com.github.otr.academy.scraper.task.topic.request.TopicRequest
import com.github.otr.academy.scraper.task.topic.request.TopicRequestType

/**
 *
 */
internal object TopicRequestFactory {

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
