package com.github.otr.academy.scraper.request_factory

import com.github.otr.academy.scraper.task.track.request.TrackRequest
import com.github.otr.academy.scraper.task.track.request.TrackRequestType

/**
 *
 */
internal object TrackRequestFactory {

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
