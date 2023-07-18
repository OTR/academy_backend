package com.github.otr.academy.scraper.task.attempt

import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.core.task.BaseParseTask
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.task.attempt.handler.ParseJsonAttemptHandler
import com.github.otr.academy.scraper.task.attempt.request.AttemptRequest

/**
 *
 */
internal class ParseAttemptTask(
    private val request: AttemptRequest
) : BaseParseTask<AttemptRequest>(request) {

    override val parseJsonHandler: Handler<Cacheable> = ParseJsonAttemptHandler()

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain = buildChainOfHandlers()
        val response = chain(request)

//         TODO: check response
        if (response.dto != null) {
            return true to listOf(SaveAttemptToDbTask(response))
        }
        return false to emptyList()
    }

}
