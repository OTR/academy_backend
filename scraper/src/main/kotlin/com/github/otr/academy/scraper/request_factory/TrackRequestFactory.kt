package com.github.otr.academy.scraper.request_factory

import data.scraper.task.track.request.TrackRequest
import data.scraper.task.track.request.TrackRequestType

/**
 *
 */
object TrackRequestFactory {

    fun getBlankTrackRequest(trackId: Int) = TrackRequest(
        type = TrackRequestType(trackId),
        pathToCacheFile = null,
        isCacheExists = null,
        sourceData = null,
        dto = null,
        isRowExists = null,
        entityFromDB = null,
        projectByLevel = emptyList()
    )

}
