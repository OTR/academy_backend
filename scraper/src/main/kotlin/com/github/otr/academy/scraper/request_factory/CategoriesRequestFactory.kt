package com.github.otr.academy.scraper.request_factory

import com.github.otr.academy.scraper.task.categories.request.CategoriesRequest
import com.github.otr.academy.scraper.task.categories.request.CategoriesRequestType

/**
 *
 */
internal object CategoriesRequestFactory {

    fun getBlankCategoriesRequest() = CategoriesRequest(
        type = CategoriesRequestType,
        categories = emptyList(),
        pathToCacheFile = null,
        isCacheExists = null,
        sourceData = null,
    )

}
