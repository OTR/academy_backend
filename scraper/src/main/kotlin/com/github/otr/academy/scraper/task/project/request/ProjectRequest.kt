package data.scraper.task.project.request

import data.scraper.core.request.BaseRequestType
import data.scraper.dto.project.ProjectDTO
import data.scraper.db_handler.CanBeDatabaseEntity
import data.scraper.cache_handler.Cacheable
import data.scraper.cache_handler.Cacheable.Companion.SEVEN_HUNDRED_BYTES
import data.scraper.core.request.Parsable

/**
 *
 */
data class ProjectRequest(
    override val type: BaseRequestType,
    override var pathToCacheFile: String?,
    override var isCacheExists: Boolean?,
    override var sourceData: String?,
    override val dto: ProjectDTO?,
    override var isRowExists: Boolean?,
    val entityFromDB: Project?,
    override val minFileLength: Long = SEVEN_HUNDRED_BYTES,
) : Cacheable, Parsable<ProjectDTO>, CanBeDatabaseEntity
