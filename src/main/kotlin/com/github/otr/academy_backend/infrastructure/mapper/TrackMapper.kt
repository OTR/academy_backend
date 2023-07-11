package com.github.otr.academy_backend.infrastructure.mapper

import com.github.otr.academy_backend.domain.model.Track
import com.github.otr.academy_backend.infrastructure.database.dbo.TrackEntity

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class TrackMapper {

    fun mapDboToDomain(entity: TrackEntity): Track = Track(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            longDescription = entity.longDescription,
            isBeta = entity.isBeta,
            isFree = entity.isFree,
            isPublic = entity.isPublic
        )

    fun mapDomainToDbo(entity: Track): TrackEntity = TrackEntity(
        id = entity.id,
        categories = emptyList(), // TODO:
        trackProjects = emptyList(),
        title = entity.title,
        description = entity.description,
        longDescription = entity.longDescription,
        isBeta = entity.isBeta,
        isFree = entity.isFree,
        isPublic = entity.isPublic
    )

}
