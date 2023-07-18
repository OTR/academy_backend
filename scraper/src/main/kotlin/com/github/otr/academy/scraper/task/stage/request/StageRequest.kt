package data.scraper.task.stage.request

import data.scraper.dto.stage.StageDTO
import data.scraper.db_handler.CanBeDatabaseEntity
import data.scraper.cache_handler.Cacheable
import data.scraper.cache_handler.Cacheable.Companion.FIVE_HUNDRED_BYTES
import data.scraper.core.request.Parsable

/**
 *
 */
data class StageRequest(
    override val type: StageRequestType,
    override var pathToCacheFile: String?,
    override var isCacheExists: Boolean?,
    override var sourceData: String?,
    override val dto: StageDTO?,
    val listOfTopics: List<Int>,
    override var isRowExists: Boolean?,
    val entityFromDB: Stage?,
    override val minFileLength: Long = FIVE_HUNDRED_BYTES,
) : Cacheable, Parsable<StageDTO>, CanBeDatabaseEntity
