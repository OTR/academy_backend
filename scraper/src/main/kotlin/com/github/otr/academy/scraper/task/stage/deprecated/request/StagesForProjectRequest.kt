package data.scraper.task.stage.deprecated.request

import data.scraper.core.request.CanBeRequested
import data.scraper.dto.stage.StageDTO
import data.scraper.cache_handler.Cacheable
import data.scraper.cache_handler.Cacheable.Companion.KILOBYTE

/**
 *
 */
data class StagesForProjectRequest(
    override val type: StagesForProjectRequestType,
    override var pathToCacheFile: String?,
    override var isCacheExists: Boolean?,
    override var sourceData: String?,
    val stagesDTO: List<StageDTO>?,
    override val minFileLength: Long = KILOBYTE,
) : CanBeRequested, Cacheable {

    // TODO: Remove secondary constructor
    constructor(projectId: Int) : this(
        type = StagesForProjectRequestType(projectId),
        pathToCacheFile = null,
        isCacheExists = null,
        sourceData = null,
        stagesDTO = emptyList()
    )

}
