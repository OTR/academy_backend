package data.scraper.cache_handler

import data.config.Config

import kotlin.io.path.Path
import kotlin.io.path.pathString

/**
 *
 */
object GetPathToCacheFile : BaseCacheHandler() {

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
