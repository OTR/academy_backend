package data.scraper.task.attempt

import data.mapper.dto_to_domain.DatasetDtoToDomainMapperImpl
import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.dto.attempt.DatasetDTO
import data.scraper.task.attempt.handler.GetAttemptFromTableHandler
import data.scraper.task.attempt.handler.InsertAttemptIntoTableHandler
import data.scraper.task.attempt.request.AttemptRequest

import di.ApplicationComponent
import di.DaggerApplicationComponent

/**
 *
 */
class SaveAttemptToDbTask(
    private val request: AttemptRequest
) : BaseTask {

    override val fullTaskName: String = "Save Topic domain entity to Topics Table on database"

    private val component: ApplicationComponent = DaggerApplicationComponent.create()

    private val firstCheckExistence: GetAttemptFromTableHandler = component.getAttemptFromTableHandler()
    private val secondCheckExistence: GetAttemptFromTableHandler = component.getAttemptFromTableHandler()
    private val insertAttemptIntoTable: InsertAttemptIntoTableHandler = component.getInsertAttemptIntoTableHandler()
    private val mapper: DatasetDtoToDomainMapperImpl = component.getDatasetDtoToDomainMapperImpl()

    override fun buildChainOfHandlers(): Handler<AttemptRequest> {
        val chain = firstCheckExistence.setNext(
            insertAttemptIntoTable.setNext(
                secondCheckExistence
            )
        )

        return chain
    }

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain: Handler<AttemptRequest> = buildChainOfHandlers()
        val response: AttemptRequest = chain(request)

        if (
            response.isRowExists == true
            && response.entityFromDB != null
            && response.dto != null
            && response.dto.dataset != null
        ) {
            val datasetDTO: DatasetDTO = response.dto.dataset
            val dataset: AttemptDataset = mapper.mapDTOtoDomain(datasetDTO, response.type.id)

            return true to listOf(
//                SaveAttemptDatasetToDbTask(
//                    StepRequest(
//                        stepId,
//                        StepRequestType(stepId)
//                    )
//                )
            )
        } else {
            throw RuntimeException("Check for prerequisites for this stage")
        }
    }

}
