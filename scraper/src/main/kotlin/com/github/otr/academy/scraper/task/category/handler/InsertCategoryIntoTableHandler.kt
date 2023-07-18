package com.github.otr.academy.scraper.task.category.handler

import com.github.otr.academy.domain.model.Category
import com.github.otr.academy.domain.repository.GenericRepository
import com.github.otr.academy.scraper.mapper.CategoryRequestMapper
import com.github.otr.academy.scraper.task.category.request.CategoryRequest

import javax.inject.Inject

/**
 *
 */
internal class InsertCategoryIntoTableHandler @Inject constructor(
    val repository: GenericRepository<Category>
): BaseCategoryHandler() {

    override val handlerName: String = "Insert Category Into Database Table"

    override fun canHandle(request: CategoryRequest): Boolean {
        return request.isRowExists == false
    }

    override fun handle(request: CategoryRequest): CategoryRequest {
        val category: Category = CategoryRequestMapper().mapToCategory(request)
        repository.save(category)

        return request
    }

}
