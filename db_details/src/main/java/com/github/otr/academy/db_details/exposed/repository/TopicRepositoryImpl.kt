package data.repository

import data.database.SQLiteDatabaseFactory
import data.table.TopicsTable
import data.table.TopicsTable.mapRowToTopic
import data.table.TopicsTable.topicId
import domain.model.Topic
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
class TopicRepositoryImpl @Inject constructor(

) : GenericRepository<Topic> {

    private val table: TopicsTable = TopicsTable
    private val database: Database = SQLiteDatabaseFactory().init(table)

    override fun save(entity: Topic) {

        transaction {
            table.insert { mapTopicToRow(it, entity) }
        }
    }

    override fun saveAll(entities: List<Topic>) {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): Topic? {
        return transaction {
            table.select { topicId eq id }
                .map { it.mapRowToTopic() }
                .singleOrNull()
        }
    }

    override fun getAll(): List<Topic> {
        return transaction {
            table.selectAll().map { it.mapRowToTopic() }
        }
    }

}
