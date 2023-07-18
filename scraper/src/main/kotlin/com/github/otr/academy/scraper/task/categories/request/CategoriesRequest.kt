package com.github.otr.academy.scraper.task.categories.request

import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.cache_handler.Cacheable.Companion.KILOBYTE
import com.github.otr.academy.scraper.task.category.request.CategoryRequest

/**
 * id equals 1 because page value query is always 1 in requested url
 * https://hyperskill.org/api/track-categories?page=1
 */
internal data class CategoriesRequest(
    override val type: CategoriesRequestType,
    val categories: List<CategoryRequest>,
    override var pathToCacheFile: String?,
    override var isCacheExists: Boolean?,
    override var sourceData: String?,
    override val minFileLength: Long = KILOBYTE,
) : Cacheable
