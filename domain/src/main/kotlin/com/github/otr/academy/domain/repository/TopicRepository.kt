package com.github.otr.academy.domain.repository

import com.github.otr.academy.domain.model.Topic


/**
 *
 */
interface TopicRepository : GenericRepository<Topic> {

    fun getAllTopicsForStageById(stageId: Int): List<Topic>

}
