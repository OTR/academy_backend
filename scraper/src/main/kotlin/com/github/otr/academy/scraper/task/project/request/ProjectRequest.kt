package com.github.otr.academy.scraper.task.project.request

import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.cache_handler.Cacheable.Companion.SEVEN_HUNDRED_BYTES
import com.github.otr.academy.scraper.core.request.BaseRequestType
import com.github.otr.academy.scraper.core.request.Parsable
import com.github.otr.academy.scraper.db_handler.DatabaseOwner
import com.github.otr.academy.scraper.dto.project.ProjectDTO

/**
 *
 */
internal data class ProjectRequest(
    override val type: BaseRequestType,
    override var pathToCacheFile: String?,
    override var isCacheExists: Boolean?,
    override var sourceData: String?,
    override val dto: ProjectDTO?,
    override var isRowExists: Boolean?,
    val entityFromDB: Project?,
    override val minFileLength: Long = SEVEN_HUNDRED_BYTES,
) : Cacheable, Parsable<ProjectDTO>, DatabaseOwner
