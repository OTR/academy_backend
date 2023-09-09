package com.github.otr.academy.scraper.mapper

import com.github.otr.academy.domain.model.AttemptDataset

import com.github.otr.academy.scraper.dto.attempt.DatasetDTO

import javax.inject.Inject

/**
 *
 */
internal class DatasetMapper @Inject constructor(

) {

    fun mapDTOtoDomain(dto: DatasetDTO, stepId: Int): AttemptDataset {
        return if (
            dto.isMultipleChoice != null && dto.options.isNotEmpty()
        ) {
            AttemptDataset(
                id = stepId,
                isMultipleChoice = dto.isMultipleChoice,
                options = dto.options
            )
        } else {
            throw IllegalArgumentException("Some of DTO fields Are null")
        }

    }

}
