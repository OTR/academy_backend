package com.github.otr.academy.scraper.mapper

import com.github.otr.academy.domain.model.Step
import com.github.otr.academy.scraper.dto.step.StepDTO

import javax.inject.Inject

/**
 *
 */
internal class StepMapper @Inject constructor(

) : GenericDtoMapper<Step, StepDTO> {

    private companion object {

        const val UNDEFINED_TOPIC_ID: Int = -1
        const val UNDEFINED_STAGE_ID: Int = -1
        const val UNDEFINED_PROJECT_ID: Int = -1

    }

    override fun mapDtoToDomain(dto: StepDTO): Step {

        if (
            dto.topic == null || dto.stage == null || dto.topicTheory == null
            || dto.project == null
        ) {
            println()
        }

        if (
            dto.id != null && dto.title != null && dto.type != null
            && dto.position != null && dto.readiness != null
            && dto.isCompleted != null && dto.isBeta != null && dto.isIdeCompatible != null
        ) {
            return Step(
                id = dto.id,
                title = dto.title,
                type = dto.type,
                topic = dto.topic ?: UNDEFINED_TOPIC_ID, // Could be nullable
                topicTheory = dto.topicTheory ?: UNDEFINED_TOPIC_ID, // could be nullable
                stage = dto.stage?.toInt() ?: UNDEFINED_STAGE_ID, // could be nullable
                position = dto.position,
                project = dto.project?.toInt() ?: UNDEFINED_PROJECT_ID,
                isCompleted = dto.isCompleted,
                isBeta = dto.isBeta,
                isIdeCompatible = dto.isIdeCompatible,
                readiness = dto.readiness
            )
        } else {
            throw IllegalArgumentException("DTO fields should not be null")
        }
    }

}
