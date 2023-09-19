package com.github.otr.academy.domain.repository

import com.github.otr.academy.domain.response.ProjectsByLevel
import com.github.otr.academy.domain.model.Track

/**
 *  Each `Track` could have several or none Projects establishing MANY-TO-MANY
 *  relationship. With extra row, which is `level`.
 *  The same project could have `easy` level for one `Track` and `medium` level
 *  for another `Track`
 */
interface TrackRepository : GenericRepository<Track> {

    fun getProjectsByLevelByTrackId(trackId: Int): ProjectsByLevel

}
