package data.scraper.task.attempt.request

import data.scraper.db_handler.CanBeDatabaseEntity
import data.scraper.dto.attempt.AttemptDTO
import data.scraper.cache_handler.Cacheable
import data.scraper.cache_handler.Cacheable.Companion.ONE_HUNDRED_BYTES
import data.scraper.core.request.Parsable
import domain.model.Attempt

/**
 *
 */
data class AttemptRequest(
    override val type: AttemptRequestType,
    override var pathToCacheFile: String?,
    override var isCacheExists: Boolean?,
    override var sourceData: String?,
    override var isRowExists: Boolean?,
    override val dto: AttemptDTO?,
    var entityFromDB: Attempt?,
    override val minFileLength: Long = ONE_HUNDRED_BYTES,
) : Cacheable, Parsable<AttemptDTO>, CanBeDatabaseEntity
