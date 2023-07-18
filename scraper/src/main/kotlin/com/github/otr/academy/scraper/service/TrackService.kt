package com.github.otr.academy.scraper.service

import com.github.otr.academy.domain.model.Track
import com.github.otr.academy.domain.use_case.track.GetAllTracksUseCase
import javax.inject.Inject

/**
 *
 */
internal class TrackService @Inject constructor(
    private val getAllTracksUseCase: GetAllTracksUseCase
) {

    fun getAllTracks(): List<Track> {
        return getAllTracksUseCase()
    }

}
