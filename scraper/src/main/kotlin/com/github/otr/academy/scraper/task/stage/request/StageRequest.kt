package com.github.otr.academy.scraper.task.stage.request

import com.github.otr.academy.domain.model.Stage
import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.cache_handler.Cacheable.Companion.FIVE_HUNDRED_BYTES
import com.github.otr.academy.scraper.core.request.Parsable
import com.github.otr.academy.scraper.db_handler.DatabaseOwner
import com.github.otr.academy.scraper.dto.stage.StageDTO

/**
 *
 */
internal data class StageRequest(
    override val type: StageRequestType,
    override var pathToCacheFile: String?,
    override var isCacheExists: Boolean?,
    override var sourceData: String?,
    override val dto: StageDTO?,
    val listOfTopics: List<Int>,
    override var isRowExists: Boolean?,
    val entityFromDB: Stage?,
    override val minFileLength: Long = FIVE_HUNDRED_BYTES,
) : Cacheable, Parsable<StageDTO>, DatabaseOwner
