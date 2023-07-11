package com.github.otr.academy_backend.domain.repository

import com.github.otr.academy_backend.domain.model.ProjectsByLevel
import com.github.otr.academy_backend.domain.model.Track

/**
 *
 */
interface TrackRepository : GenericRepository<Track> {

    fun getProjectsByLevelByTrackId(trackId: Int): ProjectsByLevel

}
