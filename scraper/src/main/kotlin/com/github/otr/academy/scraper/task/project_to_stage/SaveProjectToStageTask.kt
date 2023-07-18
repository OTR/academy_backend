package com.github.otr.academy.scraper.task.project_to_stage

import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.task.project.request.ProjectRequest

/**
 *
 */
@Deprecated("Stage row already contains Foreign key to Project Id")
internal class SaveProjectToStageTask(val request: ProjectRequest) : BaseTask {

    override val fullTaskName: String = "Create a table to assign a stages to project"

    //private val component: ApplicationComponent = DaggerApplicationComponent.create()
    //private val insertProjectToStageIntoTableHandler = component.getInsertProjectToStageIntoTableHandler()

    override fun buildChainOfHandlers(): Handler<ProjectRequest> {
        val chain = TODO()//insertProjectToStageIntoTableHandler

        return chain
    }

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain: Handler<ProjectRequest> = buildChainOfHandlers()
        val response: ProjectRequest = chain(request)

        return false to emptyList()
    }

}
