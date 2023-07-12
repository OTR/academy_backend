package com.github.otr.academy.scraper.mapper

import com.github.otr.academy.domain.model.Stage

import com.github.otr.academy.scraper.dto.stage.StageDTO

import javax.inject.Inject

/**
 *
 */
class StageDtoToDomainMapperImpl @Inject constructor(

) : GenericDtoToDomainMapper<Stage, StageDTO> {

    companion object {

        private const val UNDEFINED_STAGE_ID: Int = -1

    }

    override fun mapDtoToDomain(dto: StageDTO): Stage {
        if (
            dto.id != null && dto.title != null && dto.description != null
            && dto.longDescription != null && dto.project != null && dto.language != null
            && dto.step != null && dto.projectStagesCount != null && dto.stepIndex != null
            && dto.secondsToComplete != null && dto.isIdeRequired != null
            && dto.previewStep != null && dto.allPrerequisites.isNotEmpty()
        ) {
            return Stage(
                id = dto.id,
                title = dto.title,
                description = dto.description,
//                longDescription = dto.longDescription,
                stageProject = dto.project,
                stageLanguage = dto.language,
                stageStep = dto.step,
                stagesCount = dto.projectStagesCount,
                stageIndex = dto.stepIndex,
//                secondsToComplete = dto.secondsToComplete,
                isIdeRequired = dto.isIdeRequired,
                stagePreviewStep = dto.previewStep,
//                allPrerequisites = dto.allPrerequisites,
//                prerequisites = dto.prerequisites,
                previousStageId = dto.previousStageId?.toInt() ?: UNDEFINED_STAGE_ID
            )
        } else {
            throw IllegalArgumentException("Some of StageDTO fields are null")
        }

    }

}
