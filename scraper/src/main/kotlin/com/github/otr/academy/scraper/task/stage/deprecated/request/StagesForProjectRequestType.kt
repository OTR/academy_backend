package data.scraper.task.stage.deprecated.request

import data.scraper.core.request.BaseRequestType

import java.net.URL

import kotlin.io.path.Path
import kotlin.io.path.pathString

/**
 *
 */
class StagesForProjectRequestType(
    override val id: Int
) : BaseRequestType() {

    private val lastPath: String = id.toString()
    private val query: String = "?format=json&project=$lastPath"

    private companion object {
        private const val firstPath: String = "api"
        private const val middlePath: String = "stages"
    }

    override fun getUrl(): String {
        val path: String = listOf(RELATIVE_PATH, firstPath, middlePath)
            .joinToString("/")
        val url: String = URL(PROTOCOL, HOST, path).toString() + query
        return url
    }

    override fun getCachePath(): String {

        return Path(firstPath).resolve("${middlePath}_for_project").resolve("$lastPath.json").pathString
    }

}
