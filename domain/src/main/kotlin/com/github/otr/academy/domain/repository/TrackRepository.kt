package com.github.otr.academy.domain.repository

import com.github.otr.academy.domain.model.ProjectsByLevel
import com.github.otr.academy.domain.model.Track

/**
 *
 */
interface TrackRepository : GenericRepository<Track> {

    fun getProjectsByLevelByTrackId(trackId: Int): ProjectsByLevel

}
