package data.scraper.task.track.request

import data.scraper.dto.track.TrackDTO
import data.scraper.db_handler.CanBeDatabaseEntity
import data.scraper.cache_handler.Cacheable
import data.scraper.cache_handler.Cacheable.Companion.KILOBYTE
import data.scraper.core.request.Parsable

/**
 *
 */
data class TrackRequest(
    override val type: TrackRequestType,
    override var pathToCacheFile: String?,
    override var isCacheExists: Boolean?,
    override var sourceData: String?,
    override val dto: TrackDTO?,
    override var isRowExists: Boolean?,
    val entityFromDB: Track?,
    val projectByLevel: List<Pair<String, Int>>,
    override val minFileLength: Long = KILOBYTE
) : Cacheable, Parsable<TrackDTO> , CanBeDatabaseEntity
