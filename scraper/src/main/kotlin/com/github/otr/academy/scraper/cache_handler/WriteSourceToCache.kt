package data.scraper.cache_handler

import java.io.File

/**
 *
 */
object WriteSourceToCache : BaseCacheHandler() {

    override val handlerName: String = "Write Source Data to Cache"

    override fun canHandle(request: Cacheable): Boolean {
        TODO("Not yet implemented")
    }

    override fun handle(request: Cacheable): Cacheable {
        TODO("Not yet implemented")
    }

    override fun handleOrSkip(request: Cacheable): Cacheable {
        val sourceData = request.sourceData
        val pathToCacheFile = request.pathToCacheFile
        return if (
            sourceData != null
            && request.isCacheExists == false
            && pathToCacheFile != null
        ) {
            printPositive()
            val source: String = sourceData
            val path: String = pathToCacheFile
            val file: File = File(path)
            file.writeText(source)
            request.isCacheExists = true
            request
        } else {
            printNegative()
            request
        }

    }

}
