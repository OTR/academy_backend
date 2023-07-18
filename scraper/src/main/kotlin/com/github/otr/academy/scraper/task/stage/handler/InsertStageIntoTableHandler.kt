package com.github.otr.academy.scraper.task.stage.handler

import com.github.otr.academy.domain.model.Stage
import com.github.otr.academy.domain.repository.GenericRepository
import com.github.otr.academy.scraper.dto.stage.StageDTO
import com.github.otr.academy.scraper.mapper.GenericDtoMapper
import com.github.otr.academy.scraper.task.stage.request.StageRequest

import javax.inject.Inject

/**
 *
 */
internal class InsertStageIntoTableHandler @Inject constructor(
    private val repository: GenericRepository<Stage>,
    private val mapper: GenericDtoMapper<Stage, StageDTO>
) : BaseStageHandler() {

    override val handlerName: String = "INSERT stage INTO stages table;"

    override fun canHandle(request: StageRequest): Boolean {
        return request.isRowExists == false && request.dto != null
    }

    override fun handle(request: StageRequest): StageRequest {
        val stageDTO = request.dto
        if (stageDTO != null) {
            val stage = mapper.mapDtoToDomain(stageDTO)
            repository.save(stage)
        }

        return request
    }

}
