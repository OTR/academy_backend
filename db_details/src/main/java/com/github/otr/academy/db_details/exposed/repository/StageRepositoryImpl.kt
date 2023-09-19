package com.github.otr.academy.db_details.exposed.repository

import com.github.otr.academy.db_details.exposed.database.SQLiteDatabaseFactory
import com.github.otr.academy.db_details.exposed.dbo.StagesTable
import com.github.otr.academy.db_details.exposed.dbo.StagesTable.mapRowToStage
import com.github.otr.academy.db_details.exposed.dbo.StagesTable.stageId
import com.github.otr.academy.db_details.exposed.dbo.StagesTable.stageProject

import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.model.Stage
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

    override fun deleteById(id: Int) {
        TODO("Not yet implemented")
    }

    override fun update(entity: Stage): Stage {
        TODO("Not yet implemented")
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
