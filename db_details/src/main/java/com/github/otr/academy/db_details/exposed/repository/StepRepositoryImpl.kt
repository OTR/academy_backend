package data.repository

import data.database.SQLiteDatabaseFactory
import data.table.StepsTable
import data.table.StepsTable.mapRowToStep
import data.table.StepsTable.stepId
import data.table.StepsTable.stepType
import domain.model.Step
import domain.repository.StepRepository

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

import javax.inject.Inject

/**
 *
 */
class StepRepositoryImpl @Inject constructor(

) : StepRepository {

    private val table: StepsTable = StepsTable
    private val database: Database = SQLiteDatabaseFactory().init(table)

    override fun save(entity: Step) {
        transaction {
            table.insert { mapStepToRow(it, entity) }
        }
    }

    override fun saveAll(entities: List<Step>) {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): Step? {
        return transaction {
            table.select { stepId eq id }
                .map { it.mapRowToStep() }
                .singleOrNull()
        }
    }

    override fun getAll(): List<Step> {
        return transaction {
            table.selectAll().map { it.mapRowToStep() }
        }
    }

    /**
     * Select all steps that represent `practice` steps
     */
    override fun getAllPracticeSteps(): List<Step> {
        return transaction {
            table.select { stepType eq "practice" }
                .map { it.mapRowToStep() }
        }
    }

    /**
     * Select all steps that represent `practice` steps
     */
    override fun getAllPracticeStepsIds(): List<Int> {
        return transaction {
            table.slice(stepId).select { stepType eq "practice" }.map {
                it[stepId]
            }
        }
    }

    override fun getAllTheoryStepsIds(): List<Int> {
        return transaction {
            table.slice(stepId).select { stepType eq "theory" }.map {
                it[stepId]
            }
        }
    }

    fun deleteById(id: Int) {
        transaction {
            table.deleteWhere { stepId eq id }
        }
    }

}
