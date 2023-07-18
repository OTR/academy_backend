package data.scraper.task.track

import data.scraper.cache_handler.Cacheable
import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.core.task.BaseParseTask
import data.scraper.task.track.request.TrackRequest

import di.ApplicationComponent
import di.DaggerApplicationComponent

/**
 *
 */
class ParseTrackTask(
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
