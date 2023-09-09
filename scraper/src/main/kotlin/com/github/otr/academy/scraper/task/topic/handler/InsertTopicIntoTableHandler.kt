package com.github.otr.academy.scraper.task.topic.handler

import com.github.otr.academy.domain.model.Topic
import com.github.otr.academy.domain.repository.GenericRepository
import com.github.otr.academy.scraper.dto.topic.TopicDTO
import com.github.otr.academy.scraper.mapper.GenericDtoMapper
import com.github.otr.academy.scraper.task.topic.request.TopicRequest

import javax.inject.Inject

/**
 *
 */
internal class InsertTopicIntoTableHandler @Inject constructor(
    private val repository: GenericRepository<Topic>,
    private val mapper: GenericDtoMapper<Topic, TopicDTO>
) : BaseTopicHandler() {

    override val handlerName: String = "INSERT topic INTO topics table;"

    override fun canHandle(request: TopicRequest): Boolean {
        return request.isRowExists == false && request.dto != null
    }

    override fun handle(request: TopicRequest): TopicRequest {
        val topicDTO = request.dto
        if (topicDTO != null) {
            val topic: Topic = mapper.mapDtoToDomain(topicDTO)
            repository.save(topic)
        }

        return request
    }

}
