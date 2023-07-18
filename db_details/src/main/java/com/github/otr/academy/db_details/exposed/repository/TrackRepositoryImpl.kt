package com.github.otr.academy.db_details.exposed.repository

import com.github.otr.academy.db_details.exposed.database.SQLiteDatabaseFactory
import com.github.otr.academy.db_details.exposed.dbo.TracksTable
import com.github.otr.academy.db_details.exposed.dbo.TracksTable.mapRowToTrack
import com.github.otr.academy.db_details.exposed.dbo.TracksTable.trackId
import com.github.otr.academy.db_details.exposed.dbo.parent_child.TracksToProjectsTable
import com.github.otr.academy.db_details.exposed.dbo.parent_child.TracksToProjectsTable.projectId
import com.github.otr.academy.db_details.exposed.dbo.parent_child.TracksToProjectsTable.projectLevel
import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.model.Track
import com.github.otr.academy.domain.repository.GenericRepository

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

import javax.inject.Inject

/**
 *
 */
internal class TrackRepositoryImpl @Inject constructor(
    private val projectRepository: GenericRepository<Project>
) : GenericRepository<Track> {

    private val tracksTable: TracksTable = TracksTable
    private val tracksToProjectsTable: TracksToProjectsTable = TracksToProjectsTable
    private val database: Database = SQLiteDatabaseFactory().init(
        tracksTable,
        tracksToProjectsTable
    )

    override fun save(entity: Track): Track {
        transaction {
            tracksTable.insert { mapTrackToRow(it, entity) }
        }
        // FIXME: SELECT FROM TABLE
        return entity
    }

    fun saveAll(entities: List<Track>) {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): Track? {
        return transaction {
            tracksTable.select { trackId eq id }
                .map { it.mapRowToTrack() }
                .singleOrNull()
        }
    }

    override fun deleteById(id: Int) {
        TODO("Not yet implemented")
    }

    override fun update(entity: Track): Track {
        TODO("Not yet implemented")
    }

    private fun getProjectIdsByLevel(track: Track): Track {
        val trackId: Int = track.id
        val projectIdsByLevel: List<Pair<String, Int>> = transaction {
            tracksToProjectsTable
                .select { tracksToProjectsTable.trackId eq trackId }
                .map {
                    it[projectLevel] to it[projectId]
                }
        }

        val easyProjectIds: List<Int> = parseProjectIdsByLevel(projectIdsByLevel, "easy")
        val mediumProjectIds: List<Int> = parseProjectIdsByLevel(projectIdsByLevel, "medium")
        val hardProjectIds: List<Int> = parseProjectIdsByLevel(projectIdsByLevel, "hard")
        val challengingProjectIds: List<Int> = parseProjectIdsByLevel(projectIdsByLevel, "challenging")
        val betaProjectIds: List<Int> = parseProjectIdsByLevel(projectIdsByLevel, "beta")
        val capstoneProjectIds: List<Int> = parseProjectIdsByLevel(projectIdsByLevel, "capstone")

        return track.copy(
            // TODO:
//            easyProjects = getProjectsByIds(easyProjectIds) ,
//            mediumProjects = getProjectsByIds(mediumProjectIds),
//            hardProjects = getProjectsByIds(hardProjectIds),
//            challengingProjects = getProjectsByIds(challengingProjectIds),
//            betaProjects = getProjectsByIds(betaProjectIds),
//            capstoneProjects = getProjectsByIds(capstoneProjectIds)
        )
    }

    private fun getProjectsByIds(projectIds: List<Int>): List<Project> {
        val listOfProjects: MutableList<Project> = mutableListOf()
        projectIds.forEach {
            val project: Project? = projectRepository.getById(it)
            if (project != null) {
                listOfProjects.add(project)
            }
        }
        return listOfProjects
    }

    private fun parseProjectIdsByLevel(
        projectIdsByLevel: List<Pair<String, Int>>,
        level: String
    ): List<Int> {
        val projectIds: List<Int> = projectIdsByLevel
            .filter { it.first == level }
            .map { it.second }
        return projectIds
    }

    override fun getAll(): List<Track> {
        val tracks: List<Track> = transaction {
            tracksTable.selectAll().map { trackRow ->
                val track: Track = trackRow.mapRowToTrack()
                val trackWithProjectsByLevel = getProjectIdsByLevel(track)

                trackWithProjectsByLevel
            }
        }

        return tracks
    }

}
