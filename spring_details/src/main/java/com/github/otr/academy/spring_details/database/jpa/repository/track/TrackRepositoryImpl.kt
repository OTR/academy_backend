package com.github.otr.academy.spring_details.database.jpa.repository.track

import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.response.ProjectsByLevel
import com.github.otr.academy.domain.model.Track
import com.github.otr.academy.domain.repository.TrackRepository

import com.github.otr.academy.spring_details.database.jpa.dbo.TrackEntity
import com.github.otr.academy.spring_details.database.jpa.dbo.TrackToProjectEntity
import com.github.otr.academy.spring_details.database.jpa.mapper.TrackMapper
import com.github.otr.academy.spring_details.database.jpa.mapper.ProjectMapper
import com.github.otr.academy.spring_details.database.jpa.repository.BaseRepository

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class TrackRepositoryImpl(
    private val repository: JpaTrackRepository,
    private val trackMapper: TrackMapper,
    private val projectMapper: ProjectMapper
) : TrackRepository, BaseRepository<Track, TrackEntity>(repository, trackMapper) {

    companion object {
        private const val EASY_PROJECT_KEY: String = "easy"
        private const val MEDIUM_PROJECT_KEY: String = "medium"
        private const val HARD_PROJECT_KEY: String = "hard"
        private const val CHALLENGING_PROJECT_KEY: String = "challenging"
        private const val BETA_PROJECT_KEY: String = "beta"
        private const val CAPSTONE_PROJECT_KEY: String = "capstone"
    }

    override fun getProjectsByLevelByTrackId(trackId: Int): ProjectsByLevel {
        val trackEntity: TrackEntity = repository.findById(trackId).orElseThrow()
        val ownedProjects: List<TrackToProjectEntity> = trackEntity.trackProjects

        val easyProjects: List<Project> = ownedProjects
            .filter { it.projectLevel == EASY_PROJECT_KEY }
            .map { projectMapper.mapDboToDomain(it.project) }

        val mediumProjects: List<Project> = ownedProjects
            .filter { it.projectLevel == MEDIUM_PROJECT_KEY }
            .map { projectMapper.mapDboToDomain(it.project) }

        val hardProjects: List<Project> = ownedProjects
            .filter { it.projectLevel == HARD_PROJECT_KEY }
            .map { projectMapper.mapDboToDomain(it.project) }

        val challengingProjects: List<Project> = ownedProjects
            .filter { it.projectLevel == CHALLENGING_PROJECT_KEY }
            .map { projectMapper.mapDboToDomain(it.project) }

        val betaProjects: List<Project> = ownedProjects
            .filter { it.projectLevel == BETA_PROJECT_KEY }
            .map { projectMapper.mapDboToDomain(it.project) }

        val capstoneProjects: List<Project> = ownedProjects
            .filter { it.projectLevel == CAPSTONE_PROJECT_KEY }
            .map { projectMapper.mapDboToDomain(it.project) }

        return ProjectsByLevel(
            easyProjects = easyProjects,
            mediumProjects = mediumProjects,
            hardProjects = hardProjects,
            challengingProjects = challengingProjects,
            betaProjects = betaProjects,
            capstoneProjects = capstoneProjects
        )
    }

}
