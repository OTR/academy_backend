package com.github.otr.academy.db_details.exposed.dbo

import com.github.otr.academy.domain.model.Category

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.statements.InsertStatement

/**
 *
 */
internal object CategoriesTable : Table(name="categories") {
    val categoryId = integer("category_id")
    val categoryTitle = varchar("category_title", 255)
    val categoryDescription = varchar("category_description", 255)

    override val primaryKey: PrimaryKey = PrimaryKey(categoryId)

    /**
     * A mapper from database row to domain entity
     */
    fun ResultRow.mapRowToCategory(): Category = Category(
        id = this[categoryId],
        title = this[categoryTitle],
        description = this[categoryDescription],
//        tracks = emptyList() TODO:
    )

    /**
     * A mapper from domain entity to database row
     */
    fun mapCategoryToRow(
        statement: InsertStatement<Number>,
        category: Category
    ): InsertStatement<Number> {
        return statement.apply {
            this[categoryId] = category.id
            this[categoryTitle] = category.title
            this[categoryDescription] = category.description
        }
    }

    // TODO:
//    @Deprecated("You shouldn't convert directly form Request")
//    private fun mapFromRequest(
//        statement: InsertStatement<Number>,
//        categoryRequest: CategoryRequest
//    ): InsertStatement<Number> {
//        return statement.apply {
//            this[categoryId] = categoryRequest.type.id
//            this[categoryTitle] = categoryRequest.title
//            this[categoryDescription] = categoryRequest.description
//        }
//    }

}
