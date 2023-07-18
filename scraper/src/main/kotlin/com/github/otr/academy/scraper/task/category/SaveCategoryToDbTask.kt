package com.github.otr.academy.scraper.task.category

import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.di.ApplicationComponent
import com.github.otr.academy.scraper.task.category.handler.GetCategoryFromTableHandler
import com.github.otr.academy.scraper.task.category.handler.InsertCategoryIntoTableHandler
import com.github.otr.academy.scraper.task.category.request.CategoryRequest
import com.github.otr.academy.scraper.task.category_to_track.SaveCategoryToTrackTask


/**
 *
 */
internal class SaveCategoryToDbTask(val request: CategoryRequest) : BaseTask {

    override val fullTaskName: String = "Save Category `${request.title}` to Database"

    private val component: ApplicationComponent = DaggerApplicationComponent.create()

    private val firstCheckExistence: GetCategoryFromTableHandler = component.getCategoryFromTableHandler()
    private val secondCheckExistence: GetCategoryFromTableHandler = component.getCategoryFromTableHandler()
    private val insertCategoryIntoTableHandler: InsertCategoryIntoTableHandler = component.getInsertCategoryIntoTableHandler()

    override fun buildChainOfHandlers(): Handler<CategoryRequest> {
        val chain = firstCheckExistence.setNext(
            insertCategoryIntoTableHandler.setNext(
                secondCheckExistence
            )
        )

        return chain
    }

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain: Handler<CategoryRequest> = buildChainOfHandlers()
        val response: CategoryRequest = chain(request)

        if (response.isRowExists == true && response.entityFromDB != null) {
            return true to listOf(
                SaveCategoryToTrackTask(response)
            )
        }
        return false to emptyList()
    }

}
