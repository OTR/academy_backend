package com.github.otr.academy.scraper.task.stage.deprecated.request

import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.cache_handler.Cacheable.Companion.KILOBYTE
import com.github.otr.academy.scraper.core.request.CanBeRequested
import com.github.otr.academy.scraper.dto.stage.StageDTO

/**
 *
 */
internal data class StagesForProjectRequest(
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
