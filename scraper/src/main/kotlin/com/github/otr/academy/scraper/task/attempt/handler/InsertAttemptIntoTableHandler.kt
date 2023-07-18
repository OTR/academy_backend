package data.scraper.task.attempt.handler

import data.mapper.dto_to_domain.GenericDtoToDomainMapper
import data.scraper.dto.attempt.AttemptDTO
import data.scraper.task.attempt.request.AttemptRequest
import domain.model.Attempt
import domain.repository.GenericRepository

import javax.inject.Inject

/**
 *
 */
class InsertAttemptIntoTableHandler @Inject constructor(
    private val repository: GenericRepository<Attempt>,
    private val mapper: GenericDtoToDomainMapper<Attempt, AttemptDTO>
) : BaseAttemptHandler() {

    override val handlerName: String = "INSERT attempt INTO attempts table;"

    override fun canHandle(request: AttemptRequest): Boolean {
        return request.isRowExists == false && request.dto != null
    }

    override fun handle(request: AttemptRequest): AttemptRequest {
        val attemptDTO = request.dto
        if (attemptDTO != null) {
            val attempt: Attempt = mapper.mapDtoToDomain(attemptDTO)
            repository.save(attempt)
        }

        return request
    }

}
