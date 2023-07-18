package data.scraper.task.category_to_track

import data.mapper.CategoryRequestMapper
import data.repository.parent_children.CategoryToTrackRepositoryImpl
import data.scraper.task.category.handler.BaseCategoryHandler
import data.scraper.task.category.request.CategoryRequest

import javax.inject.Inject

/**
 *
 */
class InsertCategoryToTrackIntoTableHandler @Inject constructor(
    val repository: CategoryToTrackRepositoryImpl
) : BaseCategoryHandler() {

    override val handlerName: String = "Insert Category To Track Into Database Table"

    override fun canHandle(request: CategoryRequest): Boolean {
        return request.isRowExists == true && request.tracks.isNotEmpty()
    }

    override fun handle(request: CategoryRequest): CategoryRequest {
        val mapper: CategoryRequestMapper = CategoryRequestMapper()
        val categoryToTracks: Pair<Int, List<Int>> = mapper.mapToCategoryToTracks(request)
        repository.saveAll(categoryToTracks)

        return request
    }

}
