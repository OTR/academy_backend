package com.github.otr.academy.scraper.task.attempt.request

import com.github.otr.academy.domain.model.Attempt

import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.cache_handler.Cacheable.Companion.ONE_HUNDRED_BYTES
import com.github.otr.academy.scraper.core.request.Parsable
import com.github.otr.academy.scraper.db_handler.DatabaseOwner
import com.github.otr.academy.scraper.dto.attempt.AttemptDTO

/**
 *
 */
internal data class AttemptRequest(
    override val type: AttemptRequestType,
    override var pathToCacheFile: String?,
    override var isCacheExists: Boolean?,
    override var sourceData: String?,
    override var isRowExists: Boolean?,
    override val dto: AttemptDTO?,
    var entityFromDB: Attempt?,
    override val minFileLength: Long = ONE_HUNDRED_BYTES,
) : Cacheable, Parsable<AttemptDTO>, DatabaseOwner
