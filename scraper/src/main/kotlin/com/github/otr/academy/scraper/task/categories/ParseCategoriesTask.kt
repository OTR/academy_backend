package com.github.otr.academy.scraper.task.categories

import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.core.task.BaseParseTask
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.task.categories.handler.AddHiddenCategoryHandler
import com.github.otr.academy.scraper.task.categories.handler.ParseJsonCategoriesHandler
import com.github.otr.academy.scraper.task.categories.request.CategoriesRequest
import com.github.otr.academy.scraper.task.category.SaveCategoryToDbTask

/**
 *
 */
internal class ParseCategoriesTask(
    val request: CategoriesRequest
) : BaseParseTask<CategoriesRequest>(request) {

    override val parseJsonHandler: Handler<Cacheable> = ParseJsonCategoriesHandler()
        .setNext(AddHiddenCategoryHandler)

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
