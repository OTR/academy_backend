package com.github.otr.academy.db_details.exposed.dbo

import com.github.otr.academy.domain.model.Stage

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.statements.InsertStatement

/**
 * Excluded fields:
 *      val isIdeRequired: Boolean,
 *      val previousStageId: String
 */
internal object StagesTable : Table(name = "stages") {
    val stageId = integer("stage_id")
    val stageTitle = varchar("stage_title", 255)
    val stageDescription = varchar("stage_description", 2048)
    val stageLongDescription = varchar("stage_long_description", 4096)
    val stageLanguage = varchar("stage_language", 255)
    val stageProject = integer("stage_project")
    val stageStep = integer("stage_step")
    val stagesCount = integer("stages_count")
    val stageIndex = integer("stage_index")
    val secondsToCompleteStage = double("seconds_to_complete_stage")
    val stagePreviewStep = integer("stage_preview_step")
    val isIdeRequiredStage = bool("is_ide_required_stage")
    val previousStageId = integer("previous_stage_id")

    override val primaryKey: PrimaryKey = PrimaryKey(stageId)

    /**
     * A mapper from database row to domain entity
     */
    fun ResultRow.mapRowToStage(): Stage = Stage(
        id = this[stageId],
        title = this[stageTitle],
        description = this[stageDescription],
//        longDescription = this[stageLongDescription], // TODO:

        stageLanguage = this[stageLanguage],
        stageProject = this[stageProject],
        stageStep = this[stageStep],
        stagesCount = this[stagesCount],
        stageIndex = this[stageIndex],
//        secondsToComplete = this[secondsToCompleteStage],
        stagePreviewStep = this[stagePreviewStep],
        isIdeRequired = this[isIdeRequiredStage],

//        prerequisites = emptyList(),
//        allPrerequisites = emptyList(),
        previousStageId = this[previousStageId]
    )

    /**
     * A mapper from domain entity to database row
     */
    fun mapStageToRow(
        statement: InsertStatement<Number>,
        stage: Stage
    ): InsertStatement<Number> {
        return statement.apply {
            this[stageId] = stage.id
            this[stageTitle] = stage.title
            this[stageDescription] = stage.description
//            this[stageLongDescription] = stage.longDescription

            this[stageLanguage] = stage.stageLanguage
            this[stageProject] = stage.stageProject
            this[stageStep] = stage.stageStep
            this[stagesCount] = stage.stagesCount
            this[stageIndex] = stage.stageIndex
//            this[secondsToCompleteStage] = stage.secondsToComplete
            this[stagePreviewStep] = stage.stagePreviewStep
            this[isIdeRequiredStage] = stage.isIdeRequired
            this[previousStageId] = stage.previousStageId
        }
    }

}
