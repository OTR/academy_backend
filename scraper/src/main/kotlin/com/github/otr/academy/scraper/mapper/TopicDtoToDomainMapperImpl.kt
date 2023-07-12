package com.github.otr.academy.scraper.mapper

import com.github.otr.academy.domain.model.Topic
import com.github.otr.academy.scraper.dto.topic.TopicDTO

import javax.inject.Inject

/**
 *
 */
class TopicDtoToDomainMapperImpl @Inject constructor(

) : GenericDtoToDomainMapper<Topic, TopicDTO> {

    companion object {

        private const val UNDEFINED_STEP_ID: Int = -1

    }

    override fun mapDtoToDomain(dto: TopicDTO): Topic {
        if (
            dto.id != null && dto.rootId != null && dto.parentId != null
            && dto.title != null && dto.rootTitle != null && dto.rootSubgroupTitle != null
            && dto.theory != null && dto.depth != null
            && dto.topologicalIndex != null
            && dto.isDeprecated != null && dto.hasSteps != null && dto.isBeta != null
        // For alpha topics verification step could be null
        // && verificationStep != null
        ) {
            return Topic(
                id = dto.id,
                rootId = dto.rootId,
                parentId = dto.parentId,
                title = dto.title,
                rootTitle = dto.rootTitle,
                rootSubgroupTitle = dto.rootSubgroupTitle,
                theory = dto.theory,

//                prerequisites = dto.prerequisites,
//                hierarchy = dto.hierarchy,
//                children = dto.children,
//                followers = dto.followers,

                depth = dto.depth,
                topologicalIndex = dto.topologicalIndex,
                verificationStep = dto.verificationStep ?: UNDEFINED_STEP_ID,

                isDeprecated = dto.isDeprecated,
                hasSteps = dto.hasSteps,
                isBeta = dto.isBeta,
            )
        } else {
            throw IllegalArgumentException("Some of TopicDTO fields are null")
        }
    }

}
