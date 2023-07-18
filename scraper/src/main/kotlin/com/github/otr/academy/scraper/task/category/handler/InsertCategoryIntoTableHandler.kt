package data.scraper.task.category.handler

import data.mapper.CategoryRequestMapper
import data.scraper.task.category.request.CategoryRequest
import domain.repository.GenericRepository

import javax.inject.Inject

/**
 *
 */
class InsertCategoryIntoTableHandler @Inject constructor(
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
