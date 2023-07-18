package com.github.otr.academy.scraper.task.topic.handler

import com.github.otr.academy.scraper.cache_handler.BaseCacheHandler
import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.dto.topic.TopicContainerDTO
import com.github.otr.academy.scraper.dto.topic.TopicDTO
import com.github.otr.academy.scraper.task.topic.request.TopicRequest

import com.google.gson.Gson

import javax.inject.Inject

/**
 *
 */
internal class ParseJsonTopicHandler @Inject constructor(
    // TODO: Replace Gson with P2I
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
