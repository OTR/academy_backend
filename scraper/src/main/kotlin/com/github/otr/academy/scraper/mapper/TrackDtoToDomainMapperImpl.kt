package com.github.otr.academy.scraper.mapper

import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.model.Track
import com.github.otr.academy.scraper.dto.track.TrackDTO

import javax.inject.Inject

/**
 *
 */
class TrackDtoToDomainMapperImpl @Inject constructor(

) : GenericDtoToDomainMapper<Track, TrackDTO> {

    companion object {

        private val NO_PROJECTS: List<Project> = emptyList()

    }

    override fun mapDtoToDomain(dto: TrackDTO): Track {
        return if (
            dto.id != null && dto.title != null && dto.description != null
            && dto.longDescription != null && dto.projectsByLevel != null
            && dto.isBeta != null && dto.isFree != null && dto.isPublic != null
        ) {
            Track(
                id = dto.id,
                title = dto.title,
                description = dto.description,
                longDescription = dto.longDescription,

                // TODO: Use mapper to Project
//                easyProjects = dto.projectsByLevel.easy?.map { Project(it) } ?: NO_PROJECTS,
//                mediumProjects = dto.projectsByLevel.medium?.map { Project(it) } ?: NO_PROJECTS,
//                hardProjects = dto.projectsByLevel.hard?.map { Project(it) } ?: NO_PROJECTS,
//                challengingProjects = dto.projectsByLevel.nightmare?.map { Project(it) } ?: NO_PROJECTS,
//                betaProjects = dto.betaProjects.map { Project(it) },
//                capstoneProjects = dto.capstoneProjects.map { Project(it) },

                isBeta = dto.isBeta,
                isFree = dto.isFree,
                isPublic = dto.isPublic
            )

        } else {
            throw IllegalArgumentException("Some of Track DTO fields are null")
        }

    }

}
