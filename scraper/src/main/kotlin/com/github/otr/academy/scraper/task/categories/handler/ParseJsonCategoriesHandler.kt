package com.github.otr.academy.scraper.task.categories.handler

import com.github.otr.academy.scraper.cache_handler.BaseCacheHandler
import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.dto.category.CategoriesDTO
import com.github.otr.academy.scraper.request_factory.TrackRequestFactory
import com.github.otr.academy.scraper.task.categories.request.CategoriesRequest
import com.github.otr.academy.scraper.task.category.request.CategoryRequest
import com.github.otr.academy.scraper.task.category.request.CategoryRequestType

import com.google.gson.Gson

import javax.inject.Inject

/**
 *
 */
internal class ParseJsonCategoriesHandler @Inject constructor(
    // TODO: Replace Gson with P2I
) : BaseCacheHandler() {

    override val handlerName: String = "Parse Source JSON from cache file"

    override fun canHandle(request: Cacheable): Boolean {
        return request.sourceData != null
    }

    override fun handle(request: Cacheable): Cacheable {
        val rawJson: String = request.sourceData
            ?: throw IllegalArgumentException("Source data should not be null")

        val categoriesDto: CategoriesDTO = Gson() // TODO: Replace with DI
            .fromJson(rawJson, CategoriesDTO::class.java)

        val categories: List<CategoryRequest> = categoriesDto
            .listOfCategories.map {
                // TODO: Create a separate mapper
                CategoryRequest(
                    type = CategoryRequestType(it.id),
                    title = it.title,
                    description = it.description,
                    tracks = it.tracks.map { trackId: Int ->
                        TrackRequestFactory.getBlankTrackRequest(trackId)
                    },
                    isRowExists = null,
                    entityFromDB = null
                    )
            }

        // TODO: Remove type casts
        val response = (request as CategoriesRequest).copy(categories = categories) // TODO: Remove type

        return response
    }

}
