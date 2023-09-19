package com.github.otr.academy.db_details.exposed.database

import com.github.otr.academy.db_details.exposed.config.Config

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction

import java.sql.Connection

/**
 * Class that used for Exposed related SQLite database instance initialization
 *
 * For in-memory database use the following url
 * "jdbc:sqlite:file:test?mode=memory&cache=shared"
 */
internal class SQLiteDatabaseFactory(
    pathToDatabase: String? = null
) {
    private val pathToDatabase: String = pathToDatabase ?: Config.getPathToDatabase()

    fun init(vararg tables: Table): Database {
        val driverClassName = "org.sqlite.JDBC"
        val jdbcURL = "jdbc:sqlite:".plus(pathToDatabase)
        val database = Database.connect(jdbcURL, driverClassName)
        transaction(database) {
            SchemaUtils.checkMappingConsistence(*tables)
            SchemaUtils.createMissingTablesAndColumns(*tables)
        }
        TransactionManager.manager.defaultIsolationLevel =
            Connection.TRANSACTION_SERIALIZABLE
        return database
    }

}
