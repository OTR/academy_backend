package data.scraper.task.category.handler

import data.scraper.task.category.request.CategoryRequest
import domain.repository.GenericRepository

import javax.inject.Inject

/**
 *
 */
class GetCategoryFromTableHandler @Inject constructor(
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
