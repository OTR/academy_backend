package com.github.otr.academy.db_details.exposed.repository

import com.github.otr.academy.db_details.exposed.database.SQLiteDatabaseFactory
import com.github.otr.academy.db_details.exposed.dbo.ProjectsTable
import com.github.otr.academy.db_details.exposed.dbo.ProjectsTable.mapRowToProject
import com.github.otr.academy.db_details.exposed.dbo.ProjectsTable.projectId
import com.github.otr.academy.domain.model.Project
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
class ProjectRepositoryImpl @Inject constructor(

) : GenericRepository<Project> {

    private val table: ProjectsTable = ProjectsTable
    private val database: Database = SQLiteDatabaseFactory().init(table)

    override fun save(entity: Project) {
        transaction {
            table.insert { mapProjectToRow(it, entity) }
        }
        // FIXME: select from table
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

    override fun deleteById(id: Int) {
        TODO("Not yet implemented")
    }

    override fun update(entity: Project): Project {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Project> {
        return transaction {
            table.selectAll().map { it.mapRowToProject() }
        }
    }

}
