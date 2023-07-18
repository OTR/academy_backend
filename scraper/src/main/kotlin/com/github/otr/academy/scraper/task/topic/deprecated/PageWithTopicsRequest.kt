package data.scraper.task.topic.deprecated

import data.scraper.core.request.CanBeRequested
import data.scraper.cache_handler.Cacheable
import data.scraper.cache_handler.Cacheable.Companion.KILOBYTE

/**
 *
 */
data class PageWithTopicsRequest(
    override val type: PageWithTopicsRequestType,
    override var pathToCacheFile: String?,
    override var isCacheExists: Boolean?,
    override var sourceData: String?,
    override val minFileLength: Long = KILOBYTE,
) : CanBeRequested, Cacheable {

    // TODO: Remove secondary constructor
    constructor(pageNumber: Int) : this(
        type = PageWithTopicsRequestType(pageNumber),
        pathToCacheFile = null,
        isCacheExists = null,
        sourceData = null
    )

}
