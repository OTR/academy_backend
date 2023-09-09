package com.github.otr.academy.spring_details.database.jpa.repository.topic

import com.github.otr.academy.domain.model.Topic
import com.github.otr.academy.domain.repository.TopicRepository

import com.github.otr.academy.spring_details.database.jpa.dbo.TopicEntity
import com.github.otr.academy.spring_details.database.jpa.mapper.TopicMapper
import com.github.otr.academy.spring_details.database.jpa.repository.BaseRepository

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class TopicRepositoryImpl(
    private val repository: JpaTopicRepository,
    private val topicMapper: TopicMapper
): TopicRepository, BaseRepository<Topic, TopicEntity>(repository, topicMapper) {

    override fun getAllTopicsForStageById(stageId: Int): List<Topic> {
        TODO()
    }

}
