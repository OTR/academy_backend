package data.scraper.task.category.request

import data.scraper.core.request.CanBeRequested
import data.scraper.db_handler.CanBeDatabaseEntity
import data.scraper.task.track.request.TrackRequest

/**
 *
 */
data class CategoryRequest(
    override val type: CategoryRequestType,
    val title: String,
    val description: String,
    val tracks: List<TrackRequest>,
    override var isRowExists: Boolean?,
    val entityFromDB: Category?
) : CanBeRequested, CanBeDatabaseEntity
