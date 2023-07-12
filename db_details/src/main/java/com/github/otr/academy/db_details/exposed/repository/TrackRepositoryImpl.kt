package data.repository

import data.database.SQLiteDatabaseFactory
import data.table.TracksTable
import data.table.TracksTable.mapRowToTrack
import data.table.TracksTable.trackId
import data.table.parent_child.TracksToProjectsTable
import data.table.parent_child.TracksToProjectsTable.projectId
import data.table.parent_child.TracksToProjectsTable.projectLevel
import domain.model.Project
import domain.model.Track
import domain.repository.GenericRepository

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

import javax.inject.Inject

/**
 *
 */
class TrackRepositoryImpl @Inject constructor(
    private val projectRepository: GenericRepository<Project>
) : GenericRepository<Track> {

    private val tracksTable: TracksTable = TracksTable
    private val tracksToProjectsTable: TracksToProjectsTable = TracksToProjectsTable
    private val database: Database = SQLiteDatabaseFactory().init(
        tracksTable,
        tracksToProjectsTable
    )

    override fun save(entity: Track) {
        transaction {
            tracksTable.insert { mapTrackToRow(it, entity) }
        }
    }

    override fun saveAll(entities: List<Track>) {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): Track? {
        return transaction {
            tracksTable.select { trackId eq id }
                .map { it.mapRowToTrack() }
                .singleOrNull()
        }
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
            easyProjects = getProjectsByIds(easyProjectIds) ,
            mediumProjects = getProjectsByIds(mediumProjectIds),
            hardProjects = getProjectsByIds(hardProjectIds),
            challengingProjects = getProjectsByIds(challengingProjectIds),
            betaProjects = getProjectsByIds(betaProjectIds),
            capstoneProjects = getProjectsByIds(capstoneProjectIds)
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
