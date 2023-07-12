package com.github.otr.academy.domain.use_case.topic

import com.github.otr.academy.domain.model.Topic
import com.github.otr.academy.domain.repository.TopicRepository

/**
 *
 */
class GetTopicsForStageByIdUseCase(
    private val repository: TopicRepository
) {

    operator fun invoke(stageId: Int): List<Topic> {
        return repository.getAllTopicsForStageById(stageId)
    }

}
