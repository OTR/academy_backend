package data.scraper.task.topic.deprecated

import data.scraper.core.request.BaseRequestType

import java.net.URL

import kotlin.io.path.Path
import kotlin.io.path.pathString

/**
 *
 */
class PageWithTopicsRequestType (
    override val id: Int
) : BaseRequestType() {

    private val lastPath: String = id.toString()
    private val query: String = "?page=$lastPath&format=json"

    private companion object {
        private const val firstPath: String = "api"
        private const val middlePath: String = "topics"
    }

    override fun getUrl(): String {
        val path: String = listOf(RELATIVE_PATH, firstPath, middlePath)
            .joinToString("/")
        val url: String = URL(PROTOCOL, HOST, path).toString() + query
        return url
    }

    override fun getCachePath(): String {

        return Path(firstPath)
            .resolve("page_with_" + middlePath)
            .resolve("$lastPath.json")
            .pathString
    }

}
