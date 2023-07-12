package com.github.otr.academy.spring_details.database.jpa.mapper

import com.github.otr.academy.domain.model.Stage

import com.github.otr.academy.spring_details.database.jpa.dbo.StageEntity

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class StageMapper : DboMapper<Stage, StageEntity> {

    override fun mapDboToDomain(entity: StageEntity): Stage = Stage(
        id = entity.id,
        title = entity.title,
        description = entity.description,
        stageLanguage = entity.stageLanguage,
        stageProject = entity.stageProject,
        stageStep = entity.stageStep,
        stagesCount = entity.stagesCount,
        stageIndex = entity.stageIndex,
        stagePreviewStep = entity.stagePreviewStep,
        isIdeRequired = entity.isIdeRequired,
        previousStageId = entity.previousStageId
    )

    override fun mapDomainToDbo(entity: Stage): StageEntity = StageEntity(
        id = entity.id,
        title = entity.title,
        description = entity.description,
        stageLanguage = entity.stageLanguage,
        stageProject = entity.stageProject,
        stageStep = entity.stageStep,
        stagesCount = entity.stagesCount,
        stageIndex = entity.stageIndex,
        stagePreviewStep = entity.stagePreviewStep,
        isIdeRequired = entity.isIdeRequired,
        previousStageId = entity.previousStageId
    )

}
