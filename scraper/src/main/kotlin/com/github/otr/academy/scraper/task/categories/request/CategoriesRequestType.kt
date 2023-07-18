package data.scraper.task.categories.request

import data.scraper.core.request.BaseRequestType

import java.net.URL
import kotlin.io.path.Path
import kotlin.io.path.pathString

/**
 *
 */
object CategoriesRequestType : BaseRequestType() {

    override val id: Int = 1

    private const val middlePath: String = "api"
    private const val lastPath: String = "track-categories"

    override fun getUrl(): String {
        val path: String = listOf(RELATIVE_PATH, middlePath, lastPath).joinToString("/")
        val url: String = URL(PROTOCOL, HOST, path).toString() + JSON_QUERY
        return url
    }

    override fun getCachePath(): String {

        return Path(middlePath).resolve("$lastPath.json").pathString
    }

}
