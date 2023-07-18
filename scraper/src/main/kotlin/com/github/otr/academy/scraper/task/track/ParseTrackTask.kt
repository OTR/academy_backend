package com.github.otr.academy.scraper.task.track

import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.core.task.BaseParseTask
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.di.ApplicationComponent
import com.github.otr.academy.scraper.task.track.request.TrackRequest

/**
 *
 */
internal class ParseTrackTask(
    val request: TrackRequest
) : BaseParseTask<TrackRequest>(request) {

    private val component: ApplicationComponent = DaggerApplicationComponent.create()

    override val parseJsonHandler: Handler<Cacheable> = component.getParseJsonTrackHandler()

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain: Handler<TrackRequest> = buildChainOfHandlers()
        val response: TrackRequest = chain(request)

        // TODO: Check if data correct
        if (response.dto != null) {
            return true to listOf(SaveTrackToDbTask(response))
        }
        return false to emptyList()
    }

}
