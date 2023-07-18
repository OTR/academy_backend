package com.github.otr.academy.scraper.task.category_to_track

import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.di.ApplicationComponent
import com.github.otr.academy.scraper.task.category.request.CategoryRequest
import com.github.otr.academy.scraper.task.track.LoadTrackFromRemoteTask

import javax.inject.Inject

/**
 *
 */
internal class SaveCategoryToTrackTask @Inject constructor(
    val request: CategoryRequest
) : BaseTask {

    override val fullTaskName: String = "Create a table to assign a track to category"

    private val component: ApplicationComponent = DaggerApplicationComponent.create()
    private val insertCategoryToTrackIntoTableHandler: InsertCategoryToTrackIntoTableHandler =
        component.getInsertCategoryToTrackIntoTableHandler()

    override fun buildChainOfHandlers(): Handler<CategoryRequest> {
        val chain = insertCategoryToTrackIntoTableHandler

        return chain
    }

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain: Handler<CategoryRequest> = buildChainOfHandlers()
        val response: CategoryRequest = chain(request)

        if (response.isRowExists == true && response.entityFromDB != null) {
            return true to response.tracks.map {
                LoadTrackFromRemoteTask(it)
            }
        }
        return false to emptyList()
    }

}
