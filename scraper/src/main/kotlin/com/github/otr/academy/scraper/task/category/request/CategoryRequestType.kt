package com.github.otr.academy.scraper.task.category.request

import com.github.otr.academy.scraper.core.request.BaseRequestType

/**
 *
 */
internal class CategoryRequestType(
    override val id: Int
) : BaseRequestType() {

    override fun getUrl(): String {
        TODO("Not yet implemented")
    }

    override fun getCachePath(): String {
        TODO("Not yet implemented")
    }

}
