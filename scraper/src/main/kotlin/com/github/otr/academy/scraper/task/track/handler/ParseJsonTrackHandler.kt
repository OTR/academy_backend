package data.scraper.task.track.handler

import com.google.gson.Gson

import data.scraper.cache_handler.BaseCacheHandler
import data.scraper.dto.track.TrackContainerDTO
import data.scraper.dto.track.TrackDTO
import data.scraper.cache_handler.Cacheable
import data.scraper.task.track.request.TrackRequest

import javax.inject.Inject

/**
 *
 */
class ParseJsonTrackHandler @Inject constructor(

): BaseCacheHandler() {

    override val handlerName: String = "Parse Source JSON for Track from cache file"

    override fun canHandle(request: Cacheable): Boolean {
        return request.sourceData != null
    }

    override fun handle(request: Cacheable): Cacheable {
        val rawJson: String = request.sourceData
            ?: throw IllegalArgumentException("Source data should not be null")

        val trackContainerDTO: TrackContainerDTO = Gson() // TODO: DI
            .fromJson(rawJson, TrackContainerDTO::class.java)

        val trackDTO: TrackDTO = trackContainerDTO.tracks.first()

        val response = (request as TrackRequest).copy(dto = trackDTO)

        return response
    }

}
