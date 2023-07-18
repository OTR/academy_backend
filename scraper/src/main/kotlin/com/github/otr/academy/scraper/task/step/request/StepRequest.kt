package data.scraper.task.step.request

import data.scraper.db_handler.CanBeDatabaseEntity
import data.scraper.dto.step.StepDTO
import data.scraper.cache_handler.Cacheable
import data.scraper.cache_handler.Cacheable.Companion.THREE_HUNDRED_BYTES
import data.scraper.core.request.Parsable

/**
 *
 */
data class StepRequest(
    override val type: StepRequestType,
    override var pathToCacheFile: String?,
    override var isCacheExists: Boolean?,
    override var sourceData: String?,
    override var isRowExists: Boolean?,
    override val dto: StepDTO?,
    var entityFromDB: Step?,
    override val minFileLength: Long = THREE_HUNDRED_BYTES
) : Cacheable, Parsable<StepDTO>, CanBeDatabaseEntity
