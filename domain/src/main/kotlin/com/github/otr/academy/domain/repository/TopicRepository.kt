package com.github.otr.academy.domain.repository

import com.github.otr.academy.domain.model.Topic

/**
 * Each `Stage` could require a several topics as pre-requests
 * to be done, before `Stage` becomes available for completion
 * `Stage` and `Topic` has `MANY-TO-MANY` unidirectional relationship
 * meaning several `Stage`s could have the same `Topic` to be as pre-requests.
 * On the other hand, finding All the `Stage` for a certain `Topic` is possible
 * but has no sense
 */
interface TopicRepository : GenericRepository<Topic> {

    fun getAllTopicsForStageById(stageId: Int): List<Topic>

}
