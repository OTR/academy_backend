package data.scraper.task.categories

import data.scraper.cache_handler.Cacheable
import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.core.task.BaseParseTask
import data.scraper.task.categories.handler.AddHiddenCategoryHandler
import data.scraper.task.categories.handler.ParseJsonCategoriesHandler
import data.scraper.task.categories.request.CategoriesRequest
import data.scraper.task.category.SaveCategoryToDbTask

/**
 *
 */
class ParseCategoriesTask(
    val request: CategoriesRequest
) : BaseParseTask<CategoriesRequest>(request) {

    override val parseJsonHandler: Handler<Cacheable> = ParseJsonCategoriesHandler.setNext(
        AddHiddenCategoryHandler
    )

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain: Handler<CategoriesRequest> = buildChainOfHandlers()
        val response: CategoriesRequest = chain(request)

        val categories = response.categories

        return if (categories.isNotEmpty()) {
            true to categories.map { SaveCategoryToDbTask(it) }
        } else {
            false to emptyList()
        }
    }

}
