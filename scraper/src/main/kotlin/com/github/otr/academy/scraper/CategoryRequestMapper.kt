package com.github.otr.academy.scraper

import data.scraper.task.category.request.CategoryRequest

/**
 *
 */
class CategoryRequestMapper {

    fun mapToCategory(request: CategoryRequest) = Category(
        id = request.type.id,
        title = request.title,
        description = request.description,
        tracks = emptyList()
    )

    fun mapToCategoryToTracks(request: CategoryRequest): Pair<Int, List<Int>> {
        return request.type.id to request.tracks.map { it.type.id }
    }

}
