package com.github.otr.academy.scraper.task.stage.handler

import com.github.otr.academy.domain.model.Stage
import com.github.otr.academy.domain.repository.GenericRepository
import com.github.otr.academy.scraper.task.stage.request.StageRequest

import javax.inject.Inject

/**
 *
 */
internal class GetStageFromTableHandler @Inject constructor(
    val repository: GenericRepository<Stage>
) : BaseStageHandler() {

    override val handlerName: String = "Try to SELECT Stage FROM Stages table;"

    override fun canHandle(request: StageRequest): Boolean {
        return request.dto != null
                && request.isRowExists != true
    }

    override fun handle(request: StageRequest): StageRequest {
        val stageFromDb: Stage? = repository.getById(request.type.id)
        val result = if (stageFromDb != null) {
            request.copy(
                isRowExists = true,
                entityFromDB = stageFromDb
            )
        } else {
            request.copy(
                isRowExists = false
            )
        }
        return result
    }

}
