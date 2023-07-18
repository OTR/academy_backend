package com.github.otr.academy.scraper.cache_handler

import java.io.File
import javax.inject.Inject

/**
 *
 */
internal class ReadSourceFromCache @Inject constructor(

) : BaseCacheHandler() {

    override val handlerName: String = "Read Source Data from Cache"

    override fun canHandle(request: Cacheable): Boolean {
        return request.isCacheExists == true && request.pathToCacheFile != null
    }

    override fun handle(request: Cacheable): Cacheable {
        val sourceData: String = request.pathToCacheFile?.let { File(it).readText() } ?:
            throw RuntimeException("Path to cache file could not be null")
        request.sourceData = sourceData
        return request
    }

}
