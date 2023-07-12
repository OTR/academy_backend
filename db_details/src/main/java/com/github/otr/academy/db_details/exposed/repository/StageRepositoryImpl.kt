package data.repository

import data.database.SQLiteDatabaseFactory
import data.table.StagesTable
import data.table.StagesTable.mapRowToStage
import data.table.StagesTable.stageId
import data.table.StagesTable.stageProject
import domain.model.Project
import domain.model.Stage
import domain.repository.GenericParentChildrenRepository
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
class StageRepositoryImpl @Inject constructor(

) : GenericRepository<Stage>, GenericParentChildrenRepository<Project, Stage> {

    private val table: StagesTable = StagesTable
    private val database: Database = SQLiteDatabaseFactory().init(table)

    override fun save(entity: Stage) {
        transaction {
            table.insert { mapStageToRow(it, entity) }
        }
    }

    override fun saveAll(entities: List<Stage>) {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): Stage? {
        return transaction {
            table.select { stageId eq id }
                .map { it.mapRowToStage() }
                .singleOrNull()
        }
    }

    override fun getAll(): List<Stage> {
        return transaction {
            table.selectAll().map { it.mapRowToStage() }
        }
    }

    override fun getChildrenByParent(parent: Project): List<Stage> {
        val projectId: Int = parent.id
        return transaction {
            table.select { stageProject eq projectId }
                .map { it.mapRowToStage() }
                .sortedBy { it.stageIndex }
        }
    }

}
