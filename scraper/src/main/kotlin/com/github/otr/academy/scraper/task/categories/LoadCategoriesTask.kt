package data.scraper.task.categories

import data.scraper.core.task.BaseTask
import data.scraper.core.task.BaseLoadTask
import data.scraper.task.categories.request.CategoriesRequest

import kotlin.reflect.KClass

/**
 * Load all tracks from exposed API via JSoup
 */
class LoadCategoriesTask(
    private val request: CategoriesRequest
) : BaseLoadTask<CategoriesRequest>(request) {

    override fun positiveResponse(): KClass<out BaseTask> {
        return ParseCategoriesTask::class
    }

}
