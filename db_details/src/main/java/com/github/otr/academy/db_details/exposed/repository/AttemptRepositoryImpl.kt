package data.repository

import data.database.SQLiteDatabaseFactory
import data.table.AttemptsTable
import data.table.AttemptsTable.attemptId
import data.table.AttemptsTable.mapRowToAttempt
import domain.model.Attempt
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
class AttemptRepositoryImpl @Inject constructor(

) : GenericRepository<Attempt> {

    private val table: AttemptsTable = AttemptsTable
    private val database: Database = SQLiteDatabaseFactory().init(table)

    override fun save(entity: Attempt) {

        transaction {
            table.insert { mapAttemptToRow(it, entity) }
        }
    }

    override fun saveAll(entities: List<Attempt>) {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): Attempt? {
        return transaction {
            table.select { attemptId eq id }
                .map { it.mapRowToAttempt() }
                .singleOrNull()
        }
    }

    override fun getAll(): List<Attempt> {
        return transaction {
            table.selectAll().map { it.mapRowToAttempt() }
        }
    }

}
