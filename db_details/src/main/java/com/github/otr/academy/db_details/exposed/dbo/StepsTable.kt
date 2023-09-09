package com.github.otr.academy.db_details.exposed.dbo

import com.github.otr.academy.domain.model.Step

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.statements.InsertStatement

/*
    val isBeta: Boolean,
 */
internal object StepsTable : Table(name = "steps") {
    val stepId = integer("step_id")
    val stepTitle = varchar("step_title", 255)
    val stepType = varchar("step_type", 255)
    val stepTopic = integer("step_topic")
    val stepTopicTheory = integer("step_topic_theory")
    val stepStage = integer("step_stage")
    val stepPosition = integer("step_position")
    val stepProject = integer("step_project")
    val isCompletedStep = bool("is_completed_step")
    val isBetaStep = bool("is_beta_step")
    val isIdeCompatibleStep = bool("is_ide_compatible_step")
    val stepReadiness = varchar("step_readiness", 255)

    override val primaryKey: PrimaryKey = PrimaryKey(stepId)

    /**
     * A mapper from database row to domain entity
     */
    fun ResultRow.mapRowToStep(): Step = Step(
        id = this[stepId],
        title = this[stepTitle],
        type = this[stepType],
        topic = this[stepTopic], // Could be nullable
        topicTheory = this[stepTopicTheory],// could be nullable
        stage = this[stepStage],// could be nullable
        position = this[stepPosition],
        project = this[stepProject],
        isCompleted = this[isCompletedStep],
        isBeta = this[isBetaStep],
        isIdeCompatible = this[isIdeCompatibleStep],
        readiness = this[stepReadiness]
    )

    /**
     * A mapper from domain entity to database row
     */
    fun mapStepToRow(
        statement: InsertStatement<Number>,
        step: Step
    ): InsertStatement<Number> {
        return statement.apply {
            this[stepId] = step.id
            this[stepTitle] = step.title
            this[stepType] = step.type
            this[stepTopic] = step.topic
            this[stepTopicTheory] = step.topicTheory
            this[stepStage] = step.stage
            this[stepPosition] = step.position
            this[stepProject] = step.project
            this[isCompletedStep] = step.isCompleted
            this[isBetaStep] = step.isBeta
            this[isIdeCompatibleStep] = step.isIdeCompatible
            this[stepReadiness] = step.readiness
        }
    }

}
