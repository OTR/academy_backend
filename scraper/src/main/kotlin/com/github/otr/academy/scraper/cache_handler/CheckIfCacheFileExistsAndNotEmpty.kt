package com.github.otr.academy.scraper.cache_handler

import java.io.File

/**
 * @param minFileLength describes minimal required file length in bytes
 *          to be considered as valid
 */
internal class CheckIfCacheFileExistsAndNotEmpty : BaseCacheHandler() {

    override val handlerName: String = "Check If Cache File Exists"

    override fun canHandle(request: Cacheable): Boolean {
        return request.isCacheExists == null
    }

    override fun handle(request: Cacheable): Cacheable {
        val file: File = request.pathToCacheFile?.let { File(it) } ?:
            throw RuntimeException("Path to cache file could not be null")

        // create all the necessary parent directories
        if (!file.parentFile.exists()) {
            file.parentFile.mkdirs()
        }
        // Create a new file and return false
        if (!file.exists()) {
            file.createNewFile()
        }
        // Check it is not empty
        val status: Boolean = file.isFile && file.length() > request.minFileLength

        request.isCacheExists = status
        return request
    }

}
