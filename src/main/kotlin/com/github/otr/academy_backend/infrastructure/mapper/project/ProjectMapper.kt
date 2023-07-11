package com.github.otr.academy_backend.infrastructure.mapper.project

import com.github.otr.academy_backend.domain.model.Project
import com.github.otr.academy_backend.infrastructure.database.dbo.ProjectEntity

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class ProjectMapper {

    fun mapDboToDomain(entity: ProjectEntity): Project = Project(
        id = entity.id,
        title = entity.title,
        description = entity.description,
        longDescription = entity.description,
        environment = entity.environment,
        language = entity.projectLanguage,
        isBeta = entity.isBeta,
        isTemplateBased = entity.isTemplateBased,
        useIde = entity.useIde,
        isPublic = entity.isPublic,
        isIdeRequired = entity.isIdeRequired,
        stagesCount = entity.stagesCount,
        readiness = entity.readiness
    )

    fun mapDomainToDbo(entity: Project): ProjectEntity = ProjectEntity(
        id = entity.id,
        title = entity.title,
        description = entity.description,
        longDescription = entity.description,
        environment = entity.environment,
        projectLanguage = entity.language,
        isBeta = entity.isBeta,
        isTemplateBased = entity.isTemplateBased,
        useIde = entity.useIde,
        isPublic = entity.isPublic,
        isIdeRequired = entity.isIdeRequired,
        stagesCount = entity.stagesCount,
        readiness = entity.readiness,
        projectTracks = emptyList() // TODO:
    )

}
