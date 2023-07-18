package com.github.otr.academy.db_details.exposed.repository

import com.github.otr.academy.db_details.exposed.database.SQLiteDatabaseFactory
import com.github.otr.academy.db_details.exposed.dbo.TopicsTable
import com.github.otr.academy.db_details.exposed.dbo.TopicsTable.mapRowToTopic
import com.github.otr.academy.db_details.exposed.dbo.TopicsTable.topicId
import com.github.otr.academy.domain.model.Topic
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
internal class TopicRepositoryImpl @Inject constructor(

) : GenericRepository<Topic> {

    private val table: TopicsTable = TopicsTable
    private val database: Database = SQLiteDatabaseFactory().init(table)

    override fun save(entity: Topic): Topic {

        transaction {
            table.insert { mapTopicToRow(it, entity) }
        }
        // FIXME: SELECT FROM TABLE
        return entity
    }

    fun saveAll(entities: List<Topic>) {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): Topic? {
        return transaction {
            table.select { topicId eq id }
                .map { it.mapRowToTopic() }
                .singleOrNull()
        }
    }

    override fun deleteById(id: Int) {
        TODO("Not yet implemented")
    }

    override fun update(entity: Topic): Topic {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Topic> {
        return transaction {
            table.selectAll().map { it.mapRowToTopic() }
        }
    }

}
