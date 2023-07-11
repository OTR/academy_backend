package com.github.otr.academy_backend.use_case.topic

import com.github.otr.academy_backend.domain.model.Topic
import com.github.otr.academy_backend.domain.repository.TopicRepository

import org.springframework.stereotype.Service

/**
 *
 */
@Service
class GetTopicsForStageByIdUseCase(
    private val repository: TopicRepository
) {

    operator fun invoke(stageId: Int): List<Topic> {
        return repository.getAllTopicsForStageById(stageId)
    }

}