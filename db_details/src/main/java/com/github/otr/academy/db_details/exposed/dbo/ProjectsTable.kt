package com.github.otr.academy.db_details.exposed.dbo

import com.github.otr.academy.domain.model.Project

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.statements.InsertStatement

/**
 *
 */
internal object ProjectsTable : Table(name = "projects") {
    val projectId = integer("project_id")
    val projectTitle = varchar("project_title", 255)
    val projectDescription = varchar("project_description", 2048)
    val projectLongDescription = varchar("project_long_description", 4096)
    val projectEnvironment = varchar("project_environment", 255)
    val projectLanguage = varchar("project_language", 255)
    val isBetaProject = bool("is_beta_project")
    val isTemplateBasedProject = bool("is_template_based_project")
    val useIdeProject = bool("use_ide_project")
    val isPublicProject = bool("is_public_project")
    val isIdeRequiredProject = bool("is_ide_required_project")
    val projectStagesCount = integer("project_stages_count")
    val projectReadiness = integer("project_readiness")

    override val primaryKey: PrimaryKey = PrimaryKey(projectId)

    /**
     * A mapper from database row to domain entity
     */
    fun ResultRow.mapRowToProject(): Project = Project(
        id = this[projectId],
        title = this[projectTitle],
        description = this[projectDescription],
        longDescription = this[projectLongDescription],
        environment = this[projectEnvironment],
        language = this[projectLanguage],
        isBeta = this[isBetaProject],
        isTemplateBased = this[isTemplateBasedProject],
        useIde = this[useIdeProject],
        isPublic = this[isPublicProject],
        isIdeRequired = this[isIdeRequiredProject],
        stagesCount = this[projectStagesCount],
//        stagesIds = emptyList(), // TODO:
        readiness = this[projectReadiness]
    )

    /**
     * A mapper from domain entity to database row
     */
    fun mapProjectToRow(
        statement: InsertStatement<Number>,
        project: Project
    ): InsertStatement<Number> {
        return statement.apply {
            this[projectId] = project.id
            this[projectTitle] = project.title
            this[projectDescription] = project.description
            this[projectLongDescription] = project.longDescription
            this[projectEnvironment] = project.environment
            this[projectLanguage] = project.language
            this[isBetaProject] = project.isBeta
            this[isTemplateBasedProject] = project.isTemplateBased
            this[useIdeProject] = project.useIde
            this[isPublicProject] = project.isPublic
            this[isIdeRequiredProject] = project.isIdeRequired
            this[projectStagesCount] = project.stagesCount
            this[projectReadiness] = project.readiness
        }
    }

}
