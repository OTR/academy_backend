package com.github.otr.academy_backend.domain.repository

import com.github.otr.academy_backend.domain.model.Topic


/**
 *
 */
interface TopicRepository : GenericRepository<Topic> {

    fun getAllTopicsForStageById(stageId: Int): List<Topic>

}
