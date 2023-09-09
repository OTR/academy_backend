package com.github.otr.academy.scraper.task.project_to_stage


import com.github.otr.academy.scraper.task.project.handler.BaseProjectHandler
import com.github.otr.academy.scraper.task.project.request.ProjectRequest

import javax.inject.Inject

/**
 *
 */
@Deprecated("Stage row already contains Foreign key to Project Id")
internal class InsertProjectToStageIntoTableHandler @Inject constructor(
    private val repository: ProjectToStageRepositoryImpl
) : BaseProjectHandler() {

    override val handlerName: String = "Insert Project To Stages Into Database Table"

    override fun canHandle(request: ProjectRequest): Boolean {
        return request.dto != null && request.dto.stagesIds.isNotEmpty()
    }

    override fun handle(request: ProjectRequest): ProjectRequest {
        if (request.dto != null) {
            val stagesToStageIndexList = buildList {
                request.dto.stagesIds.forEachIndexed { stageIndex, stageId ->
                    add(stageIndex to stageId)
                }
            }
            val trackToProjects: Pair<Int, List<Pair<Int, Int>>> = request.type.id to stagesToStageIndexList
            repository.saveAll(trackToProjects)
        }

        return request
    }

}
