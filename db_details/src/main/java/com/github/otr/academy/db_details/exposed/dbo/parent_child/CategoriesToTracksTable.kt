package com.github.otr.academy.db_details.exposed.dbo.parent_child

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

/**
 *
 */
internal object CategoriesToTracksTable : Table(name = "categories_to_tracks") {
    val categoryId = integer("category_id")
    val trackId = integer("track_id")

    init {
        uniqueIndex(categoryId, trackId)
    }

    fun ResultRow.mapToTrackId(): Int {
        return this[trackId]
    }

}
