package data.repository.parent_children

import data.database.SQLiteDatabaseFactory
import data.table.parent_child.TracksToProjectsTable

import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

import org.sqlite.SQLiteException

import javax.inject.Inject

/**
 *
 */
class TrackToProjectRepositoryImpl @Inject constructor(

) {

    private val table: TracksToProjectsTable = TracksToProjectsTable
    private val database: Database = SQLiteDatabaseFactory().init(table)

    fun saveAll(trackToProjectsByLevel: Pair<Int, List<Pair<String, Int>>>) {
        val _trackId: Int = trackToProjectsByLevel.first
        val projectsByLevel: List<Pair<String, Int>> = trackToProjectsByLevel.second
        transaction {
            for (projectByLevel in projectsByLevel) {
                val _level: String = projectByLevel.first
                val _projectId = projectByLevel.second
                try {
                    table.insert {
                        it[trackId] = _trackId
                        it[projectLevel] = _level
                        it[projectId] = _projectId
                    }
                } catch (e: ExposedSQLException) {
                    val cause = e.cause
                    if (
                        cause is SQLiteException
                        && cause.resultCode.name == "SQLITE_CONSTRAINT_UNIQUE"
                    ) {
                        continue
                    }
                    throw e
                }
            }
        }
    }

}
