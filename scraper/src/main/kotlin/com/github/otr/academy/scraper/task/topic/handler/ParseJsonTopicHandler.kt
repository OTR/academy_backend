package data.scraper.task.topic.handler

import com.google.gson.Gson

import data.scraper.cache_handler.BaseCacheHandler
import data.scraper.dto.topic.TopicContainerDTO
import data.scraper.dto.topic.TopicDTO
import data.scraper.cache_handler.Cacheable
import data.scraper.task.topic.request.TopicRequest

import javax.inject.Inject

/**
 *
 */
class ParseJsonTopicHandler @Inject constructor(

) : BaseCacheHandler() {

    override val handlerName: String = "Parse JSON to Topic DTO handler"

    override fun canHandle(request: Cacheable): Boolean {
        return request.sourceData != null
    }

    override fun handle(request: Cacheable): Cacheable {
        val rawJson: String = request.sourceData
            ?: throw IllegalArgumentException("Source data should not be null")

        // TODO: Replace with DI
        val topicContainerDTO: TopicContainerDTO = Gson()
            .fromJson(rawJson, TopicContainerDTO::class.java)

        val topicDTO: TopicDTO = topicContainerDTO.topics.first()

        val response = (request as TopicRequest).copy(dto = topicDTO)

        return response
    }

}
