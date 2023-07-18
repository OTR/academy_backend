package data.scraper.task.categories.request

import data.scraper.task.category.request.CategoryRequest
import data.scraper.cache_handler.Cacheable
import data.scraper.cache_handler.Cacheable.Companion.KILOBYTE

/**
 * id equals 1 because page value query is always 1 in requested url
 * https://hyperskill.org/api/track-categories?page=1
 */
data class CategoriesRequest(
    override val type: CategoriesRequestType,
    val categories: List<CategoryRequest>,
    override var pathToCacheFile: String?,
    override var isCacheExists: Boolean?,
    override var sourceData: String?,
    override val minFileLength: Long = KILOBYTE,
) : Cacheable
