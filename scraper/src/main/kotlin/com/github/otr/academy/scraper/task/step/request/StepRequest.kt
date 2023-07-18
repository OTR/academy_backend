package com.github.otr.academy.scraper.task.step.request

import com.github.otr.academy.domain.model.Step
import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.cache_handler.Cacheable.Companion.THREE_HUNDRED_BYTES
import com.github.otr.academy.scraper.core.request.Parsable
import com.github.otr.academy.scraper.db_handler.DatabaseOwner
import com.github.otr.academy.scraper.dto.step.StepDTO

/**
 *
 */
internal data class StepRequest(
    override val type: StepRequestType,
    override var pathToCacheFile: String?,
    override var isCacheExists: Boolean?,
    override var sourceData: String?,
    override var isRowExists: Boolean?,
    override val dto: StepDTO?,
    var entityFromDB: Step?,
    override val minFileLength: Long = THREE_HUNDRED_BYTES
) : Cacheable, Parsable<StepDTO>, DatabaseOwner
