package com.github.otr.academy.scraper.task.topic.request

import com.github.otr.academy.domain.model.Topic
import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.cache_handler.Cacheable.Companion.THREE_HUNDRED_BYTES
import com.github.otr.academy.scraper.core.request.Parsable
import com.github.otr.academy.scraper.db_handler.DatabaseOwner
import com.github.otr.academy.scraper.dto.topic.TopicDTO

/**
 *
 */
internal data class TopicRequest(
    override val type: TopicRequestType,
    override var pathToCacheFile: String?,
    override var isCacheExists: Boolean?,
    override var sourceData: String?,
    override val dto: TopicDTO?,
    override var isRowExists: Boolean?,
    var entityFromDB: Topic?,
    override val minFileLength: Long = THREE_HUNDRED_BYTES
) : Cacheable, Parsable<TopicDTO>, DatabaseOwner
