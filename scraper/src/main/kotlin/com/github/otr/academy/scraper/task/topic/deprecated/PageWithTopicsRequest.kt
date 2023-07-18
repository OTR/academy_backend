package com.github.otr.academy.scraper.task.topic.deprecated

import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.cache_handler.Cacheable.Companion.KILOBYTE
import com.github.otr.academy.scraper.core.request.CanBeRequested

/**
 *
 */
internal data class PageWithTopicsRequest(
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
