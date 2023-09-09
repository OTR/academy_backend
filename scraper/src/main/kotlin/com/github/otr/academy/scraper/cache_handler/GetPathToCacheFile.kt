package com.github.otr.academy.scraper.cache_handler

import com.github.otr.academy.scraper.config.Config

import javax.inject.Inject

import kotlin.io.path.Path
import kotlin.io.path.pathString

/**
 *
 */
internal class GetPathToCacheFile @Inject constructor(
    // TODO: Inject config
) : BaseCacheHandler() {

    override val handlerName: String = "Get Path To Cache File"

    override fun canHandle(request: Cacheable): Boolean {
        return request.pathToCacheFile == null
    }

    override fun handle(request: Cacheable): Cacheable {
        val cacheDirPath: String = Config.getPathToCacheDir()
        val relativePath: String = request.type.getCachePath()
        val path: String = Path(cacheDirPath).resolve(relativePath).pathString
        request.pathToCacheFile = path
        return request
    }

}
