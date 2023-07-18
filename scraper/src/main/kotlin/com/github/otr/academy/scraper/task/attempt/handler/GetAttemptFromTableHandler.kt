package data.scraper.task.attempt.handler

import data.scraper.task.attempt.request.AttemptRequest
import domain.model.Attempt
import domain.repository.GenericRepository

import javax.inject.Inject

/**
 *
 */
class GetAttemptFromTableHandler @Inject constructor(
    private val repository: GenericRepository<Attempt>
) : BaseAttemptHandler() {

    override val handlerName: String = "Try to SELECT Attempt FROM Attempts table;"

    override fun canHandle(request: AttemptRequest): Boolean {
        return request.dto != null
                && request.isRowExists != true
    }

    override fun handle(request: AttemptRequest): AttemptRequest {

        val attemptFromDb: Attempt? = repository.getById(request.type.id)
        val result = if (attemptFromDb != null) {
            request.copy(
                isRowExists = true,
                entityFromDB = attemptFromDb
            )
        } else {
            request.copy(
                isRowExists = false
            )
        }
        return result
    }

}
