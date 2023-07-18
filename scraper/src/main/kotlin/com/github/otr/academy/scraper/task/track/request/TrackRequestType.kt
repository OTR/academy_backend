package data.scraper.task.track.request

import data.scraper.core.request.BaseRequestType

import java.net.URL

import kotlin.io.path.Path
import kotlin.io.path.pathString

/**
 *
 */
class TrackRequestType(
    override val id: Int
) : BaseRequestType() {

    private val lastPath: String = id.toString()

    private companion object {
        private const val firstPath: String = "api"
        private const val middlePath: String = "tracks"
    }

    override fun getUrl(): String {
        val path: String = listOf(RELATIVE_PATH, firstPath, middlePath, lastPath)
            .joinToString("/")
        val url: String = URL(PROTOCOL, HOST, path).toString() + JSON_QUERY
        return url
    }

    override fun getCachePath(): String {

        return Path(firstPath).resolve(middlePath).resolve("$lastPath.json").pathString
    }

}
