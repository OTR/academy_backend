package com.github.otr.academy.db_details.exposed.dbo.parent_child

import org.jetbrains.exposed.sql.Table

/**
 *
 */
internal object TracksToProjectsTable : Table(name = "tracks_to_projects") {
    val trackId = integer("track_id")
    val projectId = integer("project_id")
    val projectLevel = varchar("project_level", 255)

    init {
        uniqueIndex(trackId, projectLevel, projectId)
    }

}
