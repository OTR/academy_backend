package com.github.otr.academy.domain.repository

import com.github.otr.academy.domain.model.Stage

/**
 *
 */
interface StageRepository : GenericRepository<Stage> {

    fun getStagesByProjectId(projectId: Int): List<Stage>

}
