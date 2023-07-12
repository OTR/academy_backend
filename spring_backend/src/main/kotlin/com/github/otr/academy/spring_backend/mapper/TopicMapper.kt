package com.github.otr.academy.spring_backend.mapper

import com.github.otr.academy.domain.model.Topic

import com.github.otr.academy.spring_backend.database.dbo.TopicEntity

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class TopicMapper : Mapper<Topic, TopicEntity> {

    override fun mapDboToDomain(entity: TopicEntity): Topic = Topic(
        id = entity.id,
        rootId = entity.rootId,
        parentId = entity.parentId,
        title = entity.title,
        rootTitle = entity.rootTitle,
        rootSubgroupTitle = entity.rootSubgroupTitle,
        theory = entity.theory,
        depth = entity.depth,
        topologicalIndex = entity.topologicalIndex,
        verificationStep = entity.verificationStep,
        isDeprecated = entity.isDeprecated,
        hasSteps = entity.hasSteps,
        isBeta = entity.isBeta
    )

    override fun mapDomainToDbo(entity: Topic): TopicEntity = TopicEntity(
        id = entity.id,
        rootId = entity.rootId,
        parentId = entity.parentId,
        title = entity.title,
        rootTitle = entity.rootTitle,
        rootSubgroupTitle = entity.rootSubgroupTitle,
        theory = entity.theory,
        depth = entity.depth,
        topologicalIndex = entity.topologicalIndex,
        verificationStep = entity.verificationStep,
        isDeprecated = entity.isDeprecated,
        hasSteps = entity.hasSteps,
        isBeta = entity.isBeta
    )

}
