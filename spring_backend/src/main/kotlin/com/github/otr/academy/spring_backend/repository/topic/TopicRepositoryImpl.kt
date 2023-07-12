package com.github.otr.academy.spring_backend.repository.topic

import com.github.otr.academy.domain.model.Topic
import com.github.otr.academy.domain.repository.TopicRepository

import com.github.otr.academy.spring_backend.database.dbo.TopicEntity
import com.github.otr.academy.spring_backend.database.mapper.TopicMapper
import com.github.otr.academy.spring_backend.repository.BaseRepository

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
