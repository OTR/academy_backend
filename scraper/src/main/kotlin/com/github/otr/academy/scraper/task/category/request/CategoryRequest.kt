package com.github.otr.academy.scraper.task.category.request

import com.github.otr.academy.domain.model.Category
import com.github.otr.academy.scraper.core.request.CanBeRequested
import com.github.otr.academy.scraper.db_handler.DatabaseOwner
import com.github.otr.academy.scraper.task.track.request.TrackRequest

/**
 *
 */
internal data class CategoryRequest(
    override val type: CategoryRequestType,
    val title: String,
    val description: String,
    val tracks: List<TrackRequest>,
    override var isRowExists: Boolean?,
    val entityFromDB: Category?
) : CanBeRequested, DatabaseOwner
