package com.github.otr.academy.scraper.mapper

import com.github.otr.academy.domain.model.Category
import com.github.otr.academy.scraper.task.category.request.CategoryRequest

/**
 *
 */
internal class CategoryRequestMapper {

    fun mapToCategory(request: CategoryRequest) = Category(
        id = request.type.id,
        title = request.title,
        description = request.description,
//        tracks = emptyList() // TODO: deal with Domain Model
    )

    fun mapToCategoryToTracks(request: CategoryRequest): Pair<Int, List<Int>> {
        return request.type.id to request.tracks.map { it.type.id }
    }

}
