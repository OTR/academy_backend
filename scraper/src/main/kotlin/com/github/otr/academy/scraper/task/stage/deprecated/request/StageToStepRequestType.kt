package data.scraper.task.stage.deprecated.request

import data.scraper.core.request.BaseRequestType

import java.net.URL

import kotlin.io.path.Path
import kotlin.io.path.pathString

/**
 *
 */
class StageToStepRequestType(
    override val id: Int,
    stepId: Int
) : BaseRequestType() {

    private val lastUrlPath: String = stepId.toString()
    private val lastDiskPath: String = id.toString()

    private companion object {
        private const val firstPath: String = "api"
        private const val middleUrlPath: String = "steps"
        private const val middleDiskPath: String = "stages"
    }

    override fun getUrl(): String {
        val path: String = listOf(RELATIVE_PATH, firstPath, middleUrlPath, lastUrlPath)
            .joinToString("/")
        val url: String = URL(PROTOCOL, HOST, path).toString() + JSON_QUERY
        return url
    }

    override fun getCachePath(): String {

        return Path(firstPath).resolve(middleDiskPath).resolve("$lastDiskPath.json").pathString
    }

}
