package com.github.otr.academy_backend.domain.repository

import com.github.otr.academy_backend.domain.model.Stage

/**
 *
 */
interface StageRepository : GenericRepository<Stage> {

    fun getStagesByProjectId(projectId: Int): List<Stage>

}
