package data.scraper.task.topic.handler

import data.scraper.task.topic.request.TopicRequest
import domain.repository.GenericRepository

import javax.inject.Inject

/**
 *
 */
class GetTopicFromTableHandler @Inject constructor(
    val repository: GenericRepository<Topic>
) : BaseTopicHandler() {

    override val handlerName: String = "Try to SELECT Topic FROM Topics table;"

    override fun canHandle(request: TopicRequest): Boolean {
        return request.dto != null
                && request.isRowExists != true
    }

    override fun handle(request: TopicRequest): TopicRequest {
        val stageFromDb: Topic? = repository.getById(request.type.id)
        val result = if (stageFromDb != null) {
            request.copy(
                isRowExists = true,
                entityFromDB = stageFromDb
            )
        } else {
            request.copy(
                isRowExists = false
            )
        }
        return result
    }

}
