package data.scraper.task.topic.request

import data.scraper.db_handler.CanBeDatabaseEntity
import data.scraper.dto.topic.TopicDTO
import data.scraper.cache_handler.Cacheable
import data.scraper.cache_handler.Cacheable.Companion.THREE_HUNDRED_BYTES
import data.scraper.core.request.Parsable

/**
 *
 */
data class TopicRequest(
    override val type: TopicRequestType,
    override var pathToCacheFile: String?,
    override var isCacheExists: Boolean?,
    override var sourceData: String?,
    override val dto: TopicDTO?,
    override var isRowExists: Boolean?,
    var entityFromDB: Topic?,
    override val minFileLength: Long = THREE_HUNDRED_BYTES
) : Cacheable, Parsable<TopicDTO>, CanBeDatabaseEntity
