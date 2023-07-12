package data.repository

import data.database.SQLiteDatabaseFactory
import data.table.ProjectsTable
import data.table.ProjectsTable.mapRowToProject
import data.table.ProjectsTable.projectId
import domain.model.Project
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
class ProjectRepositoryImpl @Inject constructor(

) : GenericRepository<Project> {

    private val table: ProjectsTable = ProjectsTable
    private val database: Database = SQLiteDatabaseFactory().init(table)

    override fun save(entity: Project) {
        transaction {
            table.insert { mapProjectToRow(it, entity) }
        }
    }

    override fun saveAll(entities: List<Project>) {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): Project? {
        return transaction {
            table.select { projectId eq id }
                .map { it.mapRowToProject() }
                .singleOrNull()
        }
    }

    override fun getAll(): List<Project> {
        return transaction {
            table.selectAll().map { it.mapRowToProject() }
        }
    }

}
