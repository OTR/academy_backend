package com.github.otr.academy.scraper.task.track.request

import com.github.otr.academy.domain.model.Track
import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.cache_handler.Cacheable.Companion.KILOBYTE
import com.github.otr.academy.scraper.core.request.Parsable
import com.github.otr.academy.scraper.db_handler.DatabaseOwner
import com.github.otr.academy.scraper.dto.track.TrackDTO

/**
 *
 */
internal data class TrackRequest(
    override val type: TrackRequestType,
    override var pathToCacheFile: String?,
    override var isCacheExists: Boolean?,
    override var sourceData: String?,
    override val dto: TrackDTO?,
    override var isRowExists: Boolean?,
    val entityFromDB: Track?,
    val projectByLevel: List<Pair<String, Int>>,
    override val minFileLength: Long = KILOBYTE
) : Cacheable, Parsable<TrackDTO> , DatabaseOwner
