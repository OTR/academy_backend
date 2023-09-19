package com.github.otr.academy.domain.use_case.topic

import com.github.otr.academy.domain.model.Topic
import com.github.otr.academy.domain.repository.TopicRepository

/**
 * Each `Stage` requires several pre-requested `Topic`s to be done
 * before `Stage` could become available for completion
 * `Stage` HAS-A `Topic` MANY-TO-MANY relationship
 */
class GetTopicsForStageByIdUseCase(
    private val repository: TopicRepository
) {

    operator fun invoke(stageId: Int): List<Topic> {
        return repository.getAllTopicsForStageById(stageId)
    }

}
