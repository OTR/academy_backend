package com.github.otr.academy.scraper.task.category.handler

import com.github.otr.academy.domain.model.Category
import com.github.otr.academy.domain.repository.GenericRepository
import com.github.otr.academy.scraper.task.category.request.CategoryRequest

import javax.inject.Inject

/**
 *
 */
internal class GetCategoryFromTableHandler @Inject constructor(
    private val repository: GenericRepository<Category>
): BaseCategoryHandler() {

    override val handlerName: String = "SELECT Category Row From Database Table"

    override fun canHandle(request: CategoryRequest): Boolean {
        return request.tracks.isNotEmpty()
                && request.isRowExists != true
    }

    override fun handle(request: CategoryRequest): CategoryRequest {

        val categoryFromDb: Category? = repository.getById(request.type.id)
        val result = if (categoryFromDb != null) {
            request.copy(
                isRowExists = true,
                entityFromDB = categoryFromDb
            )
        } else {
            request.copy(
                isRowExists = false
            )
        }
        return result
    }

}
