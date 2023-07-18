package data.scraper.task.category

import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.task.category.handler.GetCategoryFromTableHandler
import data.scraper.task.category.handler.InsertCategoryIntoTableHandler
import data.scraper.task.category.request.CategoryRequest
import data.scraper.task.category_to_track.SaveCategoryToTrackTask

import di.ApplicationComponent
import di.DaggerApplicationComponent

/**
 *
 */
class SaveCategoryToDbTask(val request: CategoryRequest) : BaseTask {

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
