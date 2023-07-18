package com.github.otr.academy.scraper.task.attempt.handler

import com.github.otr.academy.scraper.config.Config

import org.jsoup.Connection
import org.jsoup.Jsoup

import javax.inject.Inject

/**
 *
 */
internal class AttemptLoader @Inject constructor(
    // TODO: Inject config and Replace JSoup with P2I
) {

    private var csrfToken: String = Config.getCsrfToken()
    private val cookies: MutableMap<String, String> = mutableMapOf("csrftoken" to csrfToken)
    // FIXME: Get Path From Request Type
    private val host: String = Config.getHost()
    private val BASE_URL: String = "https://$host/api/attempts?format=json&step="
    private val USER_AGENT: String = Config.getUserAgent()

    fun loadAttempt(stepId: Int): Connection.Response {
        val url: String = BASE_URL + stepId.toString()

        val response: Connection.Response = Jsoup.connect(url)
            .referrer(url)
            .cookies(cookies)
            .data(mapOf("step" to stepId.toString()))
            .header("User-Agent", USER_AGENT)
            .header("X-CSRFTOKEN", csrfToken)
            .ignoreContentType(true)
            .ignoreHttpErrors(true) // FIXME: wrap with try..catch block instead
            .method(Connection.Method.POST)
            .execute()

        cookies.putAll(response.cookies())

        return response
    }

}
