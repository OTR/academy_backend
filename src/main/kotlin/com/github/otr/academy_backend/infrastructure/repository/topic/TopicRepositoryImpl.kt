package com.github.otr.academy_backend.infrastructure.repository.topic

import com.github.otr.academy_backend.domain.model.Topic
import com.github.otr.academy_backend.domain.repository.TopicRepository
import com.github.otr.academy_backend.infrastructure.database.dbo.TopicEntity
import com.github.otr.academy_backend.infrastructure.mapper.TopicMapper
import com.github.otr.academy_backend.infrastructure.repository.BaseRepository

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class TopicRepositoryImpl(
    private val repository: JpaTopicRepository,
    private val mapper: TopicMapper
): TopicRepository, BaseRepository<Topic, TopicEntity>(repository, mapper) {

    override fun getAllTopicsForStageById(stageId: Int): List<Topic> {
        TODO()
    }

}
