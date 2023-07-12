package com.github.otr.academy.scraper.mapper


import com.github.otr.academy.domain.model.Attempt
import com.github.otr.academy.domain.model.AttemptDataset

import com.github.otr.academy.scraper.dto.attempt.AttemptDTO
import javax.inject.Inject

/**
 *
 */
class AttemptDtoToDomainMapperImpl @Inject constructor(
    private val mapper: DatasetDtoToDomainMapperImpl
) : GenericDtoToDomainMapper<Attempt, AttemptDTO> {

    override fun mapDtoToDomain(dto: AttemptDTO): Attempt {
        return if (
            dto.id != null && dto.dataset != null && dto.status != null && dto.step !=null
            && dto.time != null && dto.user != null && dto.timeLeft != null
        ) {
            val dataset: AttemptDataset = mapper.mapDTOtoDomain(dto.dataset, dto.id)
            Attempt(
                id = dto.id,
                dataset = dataset,
                status = dto.status,
                step = dto.step,
                time = dto.time,
                user = dto.user,
                timeLeft = dto.timeLeft
            )
        } else {
            throw IllegalArgumentException("Some of DTO fields are null")
        }

    }

}
