package com.github.otr.academy.scraper.api_handler

import com.github.otr.academy.scraper.cache_handler.BaseCacheHandler
import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.config.Config

import org.jsoup.Connection.Response // TODO: P2I
import org.jsoup.Jsoup

import javax.inject.Inject

/**
 *
 */
class LoadSourceJsonHandler @Inject constructor(
    // TODO: Inject config
) : BaseCacheHandler() {

    override val handlerName: String = "Load Source JSON from remote server"

    private val USER_AGENT: String = Config.getUserAgent()

    private val delayInMillis: Long = Config.getDelayBetweenHttpRequests()

    override fun canHandle(request: Cacheable): Boolean {
        return request.sourceData == null
    }

    /**
     * Set the maximum bytes to read from the (uncompressed) connection into the body,
     * before the connection is closed,
     * and the input truncated (i.e. the body content will be trimmed).
     * The default maximum is 2MB. A max size of 0 is treated as an infinite amount
     * (bounded only by your patience and the memory available on your machine).
     */
    override fun handle(request: Cacheable): Cacheable {
        val url: String = request.type.getUrl()

        val response: Response = Jsoup.connect(url) // TODO: Remove concrete implementation of JSoup
            .maxBodySize(0) // DEFAULT IS 2 MB
            .header("User-Agent", USER_AGENT)
            .ignoreContentType(true)
            .ignoreHttpErrors(true) // FIXME: wrap with try..catch block instead
            .execute()

        if (response.statusCode() in 200 until 300) {
            val rawJson = response.body()
            request.sourceData = rawJson
        } else {
            logger.warn(
                "Response code is: ${response.statusCode()}" +
                "                                <---------------------"
            )
        }

        return request
    }

    override fun handleOrSkip(request: Cacheable): Cacheable {
        return if (canHandle(request)) {
            logger.trace(
                "Handling `$handlerName`" +
                "                                <---------------------"
            )
            val resp = handle(request)
            // FIXME: Make a delay of 100 millis before next HTTP Request
            Thread.sleep(delayInMillis)
            resp
        } else {
            printNegative()
            request
        }
    }

}
