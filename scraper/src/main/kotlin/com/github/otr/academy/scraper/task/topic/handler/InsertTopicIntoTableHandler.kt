package data.scraper.task.topic.handler

import data.mapper.dto_to_domain.GenericDtoToDomainMapper
import data.scraper.dto.topic.TopicDTO
import data.scraper.task.topic.request.TopicRequest
import domain.repository.GenericRepository

import javax.inject.Inject

/**
 *
 */
class InsertTopicIntoTableHandler @Inject constructor(
    private val repository: GenericRepository<Topic>,
    private val mapper: GenericDtoToDomainMapper<Topic, TopicDTO>
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
