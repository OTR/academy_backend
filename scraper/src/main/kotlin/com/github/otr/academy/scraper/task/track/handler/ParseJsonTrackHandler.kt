package com.github.otr.academy.scraper.task.track.handler

import com.github.otr.academy.scraper.cache_handler.BaseCacheHandler
import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.dto.track.TrackContainerDTO
import com.github.otr.academy.scraper.dto.track.TrackDTO
import com.github.otr.academy.scraper.task.track.request.TrackRequest

import com.google.gson.Gson

import javax.inject.Inject

/**
 *
 */
internal class ParseJsonTrackHandler @Inject constructor(
    // TODO: Replace Gson with P2I
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
