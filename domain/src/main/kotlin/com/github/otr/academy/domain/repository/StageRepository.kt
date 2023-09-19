package com.github.otr.academy.domain.repository

import com.github.otr.academy.domain.model.Stage

/**
 * Each `Project` entity usually has several `Stage` entities
 * with `HAS-A` relationship
 */
interface StageRepository : GenericRepository<Stage> {

    fun getStagesByProjectId(projectId: Int): List<Stage>

}
