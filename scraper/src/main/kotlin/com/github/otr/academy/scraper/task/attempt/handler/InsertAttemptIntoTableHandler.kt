package com.github.otr.academy.scraper.task.attempt.handler

import com.github.otr.academy.domain.model.Attempt
import com.github.otr.academy.domain.repository.GenericRepository

import com.github.otr.academy.scraper.dto.attempt.AttemptDTO
import com.github.otr.academy.scraper.mapper.GenericDtoMapper
import com.github.otr.academy.scraper.task.attempt.request.AttemptRequest

import javax.inject.Inject

/**
 *
 */
internal class InsertAttemptIntoTableHandler @Inject constructor(
    private val repository: GenericRepository<Attempt>,
    private val mapper: GenericDtoMapper<Attempt, AttemptDTO>
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
