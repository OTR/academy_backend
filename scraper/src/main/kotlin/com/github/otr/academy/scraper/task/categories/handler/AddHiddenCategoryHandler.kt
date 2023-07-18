package data.scraper.task.categories.handler

import data.scraper.cache_handler.BaseCacheHandler
import data.scraper.datasource.DraftsCategory
import data.scraper.task.categories.request.CategoriesRequest
import data.scraper.task.category.request.CategoryRequest
import data.scraper.cache_handler.Cacheable

object AddHiddenCategoryHandler : BaseCacheHandler() {

    override val handlerName: String = "Add hidden Category to Categories List"

    private val hiddenCategory: CategoryRequest = DraftsCategory // TODO: DI

    override fun canHandle(request: Cacheable): Boolean {
        val categories = (request as CategoriesRequest).categories
        val result: Boolean =  categories.isNotEmpty()
                && categories.find { it.type.id == hiddenCategory.type.id } == null

        return result
    }

    override fun handle(request: Cacheable): Cacheable {
        request as CategoriesRequest // FIXME: No type casts
        val categories = request.categories.toMutableList()
        categories.add(hiddenCategory)

        return request.copy(categories = categories)
    }

}
