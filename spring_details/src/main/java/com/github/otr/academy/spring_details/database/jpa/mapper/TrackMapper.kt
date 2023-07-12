package com.github.otr.academy.spring_details.database.jpa.mapper

import com.github.otr.academy.domain.model.Track

import com.github.otr.academy.spring_details.database.jpa.dbo.TrackEntity

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class TrackMapper : DboMapper<Track, TrackEntity> {

    override fun mapDboToDomain(entity: TrackEntity): Track = Track(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            longDescription = entity.longDescription,
            isBeta = entity.isBeta,
            isFree = entity.isFree,
            isPublic = entity.isPublic
        )

    override fun mapDomainToDbo(entity: Track): TrackEntity = TrackEntity(
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
