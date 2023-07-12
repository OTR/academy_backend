package data.repository

import data.database.SQLiteDatabaseFactory
import data.table.CategoriesTable
import data.table.CategoriesTable.mapRowToCategory
import data.table.TracksTable
import data.table.TracksTable.mapRowToTrack
import data.table.parent_child.CategoriesToTracksTable
import domain.model.Category
import domain.model.Track
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
class CategoryRepositoryImpl @Inject constructor(

): GenericRepository<Category>, GenericParentChildrenRepository<Category, Track> {

    private val categoriesTable = CategoriesTable
    private val categoriesToTracksTable = CategoriesToTracksTable
    private val tracksTable = TracksTable
    private val database: Database = SQLiteDatabaseFactory().init(
        categoriesTable,
        categoriesToTracksTable,
        tracksTable
    )

    override fun save(entity: Category) {
        transaction {
            categoriesTable.insert { mapCategoryToRow(it, entity) }
        }
    }

    override fun saveAll(entities: List<Category>) {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): Category? {
        return transaction {
            categoriesTable.select { categoriesTable.categoryId eq id }
                .map { it.mapRowToCategory() }
                .singleOrNull()
        }
    }

    override fun getAll(): List<Category> {
        return transaction {
            categoriesTable.selectAll().map {
                val category: Category = it.mapRowToCategory()
                category.copy(
                    tracks = getChildrenByParent(category)
                )
            }
        }
    }

    override fun getChildrenByParent(parent: Category): List<Track> {
        val categoryId: Int = parent.id
        val trackIds: List<Int> = transaction {
            categoriesToTracksTable
                .slice(categoriesToTracksTable.trackId)
                .select { categoriesToTracksTable.categoryId eq categoryId }
                .map { it[categoriesToTracksTable.trackId] }
        }
        val tracks: List<Track> = transaction {
            tracksTable
                .select { tracksTable.trackId inList trackIds }
                .map { it.mapRowToTrack() }
        }
        return tracks
    }

}
