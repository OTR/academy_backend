package com.github.otr.academy.scraper.task.attempt.request

import com.github.otr.academy.scraper.core.request.BaseRequestType

import java.net.URL

import kotlin.io.path.Path
import kotlin.io.path.pathString

/**
 *
 */
internal class AttemptRequestType(override val id: Int) : BaseRequestType() {

    private val lastPath: String = id.toString()
    private val query: String = "?format=json&step=$id"

    private companion object {
        private const val firstPath: String = "api"
        private const val middlePath: String = "attempts"
    }

    /**
     * https://hyperskill.org/api/attempts?format=json&step=
     */
    override fun getUrl(): String {
        val path: String = listOf(RELATIVE_PATH, firstPath, middlePath)
            .joinToString("/")
        val url: String = URL(PROTOCOL, HOST, path).toString() + query
        return url
    }

    override fun getCachePath(): String {

        return Path(firstPath).resolve(middlePath).resolve("$lastPath.json").pathString
    }

}
