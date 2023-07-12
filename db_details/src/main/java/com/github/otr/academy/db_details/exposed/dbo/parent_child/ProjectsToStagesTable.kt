package data.table.parent_child

import org.jetbrains.exposed.sql.Table

/**
 *
 */
object ProjectsToStagesTable : Table(name = "projects_to_stages") {
    val projectId = integer("project_id")
    val stageId = integer("stage_id")
    val stageIndex = integer("stage_index")

    init {
        uniqueIndex(projectId, stageIndex, stageId)
    }

}
