package com.github.otr.academy.scraper.task.categories

import com.github.otr.academy.scraper.core.task.BaseLoadTask
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.task.categories.request.CategoriesRequest

import kotlin.reflect.KClass

/**
 * Load all tracks from exposed API via JSoup
 */
internal class LoadCategoriesTask(
    private val request: CategoriesRequest
) : BaseLoadTask<CategoriesRequest>(request) {

    override fun positiveResponse(): KClass<out BaseTask> {
        return ParseCategoriesTask::class
    }

}
