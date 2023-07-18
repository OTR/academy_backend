package com.github.otr.academy.db_details.exposed.repository

import com.github.otr.academy.db_details.exposed.database.SQLiteDatabaseFactory
import com.github.otr.academy.db_details.exposed.dbo.AttemptsTable
import com.github.otr.academy.db_details.exposed.dbo.AttemptsTable.attemptId
import com.github.otr.academy.db_details.exposed.dbo.AttemptsTable.mapRowToAttempt
import com.github.otr.academy.domain.model.Attempt
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
class AttemptRepositoryImpl @Inject constructor(

) : GenericRepository<Attempt> {

    private val table: AttemptsTable = AttemptsTable
    private val database: Database = SQLiteDatabaseFactory().init(table)

    fun save(entity: Attempt) {

        transaction {
            table.insert { mapAttemptToRow(it, entity) }
        }
    }

    fun saveAll(entities: List<Attempt>) {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): Attempt? {
        return transaction {
            table.select { attemptId eq id }
                .map { it.mapRowToAttempt() }
                .singleOrNull()
        }
    }

    override fun deleteById(id: Int) {
        TODO("Not yet implemented")
    }

    override fun update(entity: Attempt): Attempt {
        TODO("Not yet implemented")
    }

    override fun save(entity: Attempt): Attempt {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Attempt> {
        return transaction {
            table.selectAll().map { it.mapRowToAttempt() }
        }
    }

}
