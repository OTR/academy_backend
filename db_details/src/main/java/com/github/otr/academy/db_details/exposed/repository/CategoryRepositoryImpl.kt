package com.github.otr.academy.db_details.exposed.repository

import com.github.otr.academy.db_details.exposed.database.SQLiteDatabaseFactory
import com.github.otr.academy.db_details.exposed.dbo.CategoriesTable
import com.github.otr.academy.db_details.exposed.dbo.CategoriesTable.mapRowToCategory
import com.github.otr.academy.db_details.exposed.dbo.TracksTable
import com.github.otr.academy.db_details.exposed.dbo.TracksTable.mapRowToTrack
import com.github.otr.academy.db_details.exposed.dbo.parent_child.CategoriesToTracksTable

import com.github.otr.academy.domain.model.Category
import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.model.Stage
import com.github.otr.academy.domain.model.Track
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
internal class CategoryRepositoryImpl @Inject constructor(

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

    override fun deleteById(id: Int) {
        TODO("Not yet implemented")
    }

    override fun update(entity: Category): Category {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Category> {
        return transaction {
            categoriesTable.selectAll().map {
                val category: Category = it.mapRowToCategory()
                category.copy(
//                    tracks = getChildrenByParent(category) // TODO: figure out Domain Model
                )
            }
        }
    }

    fun getChildrenByParent(parent: Category): List<Track> {
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

    override fun getChildrenByParent(parent: Project): List<Stage> {
        TODO("Not yet implemented")
    }

}
