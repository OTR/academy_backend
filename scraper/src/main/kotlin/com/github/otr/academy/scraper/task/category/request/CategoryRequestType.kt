package data.scraper.task.category.request

import data.scraper.core.request.BaseRequestType

/**
 *
 */
class CategoryRequestType(
    override val id: Int
) : BaseRequestType() {

    override fun getUrl(): String {
        TODO("Not yet implemented")
    }

    override fun getCachePath(): String {
        TODO("Not yet implemented")
    }

}
