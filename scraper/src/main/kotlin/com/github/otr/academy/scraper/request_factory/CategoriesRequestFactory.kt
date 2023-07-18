package com.github.otr.academy.scraper.request_factory

import data.scraper.task.categories.request.CategoriesRequest
import data.scraper.task.categories.request.CategoriesRequestType

/**
 *
 */
object CategoriesRequestFactory {

    fun getBlankCategoriesRequest() = CategoriesRequest(
        type = CategoriesRequestType,
        categories = emptyList(),
        pathToCacheFile = null,
        isCacheExists = null,
        sourceData = null,
    )

}
