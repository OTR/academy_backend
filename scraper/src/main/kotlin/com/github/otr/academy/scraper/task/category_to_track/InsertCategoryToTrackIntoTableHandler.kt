package com.github.otr.academy.scraper.task.category_to_track

import com.github.otr.academy.scraper.mapper.CategoryRequestMapper
import com.github.otr.academy.scraper.task.category.handler.BaseCategoryHandler
import com.github.otr.academy.scraper.task.category.request.CategoryRequest

import javax.inject.Inject

/**
 *
 */
internal class InsertCategoryToTrackIntoTableHandler @Inject constructor(
    private val repository: CategoryToTrackRepositoryImpl,
    private val mapper: CategoryRequestMapper = CategoryRequestMapper()
) : BaseCategoryHandler() {

    override val handlerName: String = "Insert Category To Track Into Database Table"

    override fun canHandle(request: CategoryRequest): Boolean {
        return request.isRowExists == true && request.tracks.isNotEmpty()
    }

    override fun handle(request: CategoryRequest): CategoryRequest {
        val categoryToTracks: Pair<Int, List<Int>> = mapper.mapToCategoryToTracks(request)
        repository.saveAll(categoryToTracks)

        return request
    }

}
