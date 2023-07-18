package data.scraper.task.stage.handler

import data.mapper.dto_to_domain.GenericDtoToDomainMapper
import data.scraper.dto.stage.StageDTO
import data.scraper.task.stage.request.StageRequest
import domain.repository.GenericRepository

import javax.inject.Inject

/**
 *
 */
class InsertStageIntoTableHandler @Inject constructor(
    private val repository: GenericRepository<Stage>,
    private val mapper: GenericDtoToDomainMapper<Stage, StageDTO>
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
