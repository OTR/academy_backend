package com.github.otr.academy_backend.infrastructure.repository.stage

import com.github.otr.academy_backend.infrastructure.database.dbo.StageEntity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface JpaStageRepository : JpaRepository<StageEntity, Int> {

    fun findAllByStageProject(stageProject: Int): List<StageEntity>

}
