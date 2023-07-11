package com.github.otr.academy_backend.infrastructure.repository.track

import com.github.otr.academy_backend.domain.model.Project
import com.github.otr.academy_backend.domain.model.ProjectsByLevel
import com.github.otr.academy_backend.domain.model.Track
import com.github.otr.academy_backend.domain.repository.TrackRepository
import com.github.otr.academy_backend.infrastructure.database.dbo.TrackEntity
import com.github.otr.academy_backend.infrastructure.database.dbo.TrackToProjectEntity
import com.github.otr.academy_backend.infrastructure.mapper.TrackMapper
import com.github.otr.academy_backend.infrastructure.mapper.project.ProjectMapper
import com.github.otr.academy_backend.infrastructure.repository.BaseRepository

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class TrackRepositoryImpl(
    private val repository: JpaTrackRepository,
    private val mapper: TrackMapper,
    private val projectMapper: ProjectMapper
) : TrackRepository, BaseRepository<Track, TrackEntity>(repository, mapper) {

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
