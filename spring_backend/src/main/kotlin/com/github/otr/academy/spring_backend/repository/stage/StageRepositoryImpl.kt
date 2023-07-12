package com.github.otr.academy.spring_backend.repository.stage

import com.github.otr.academy.domain.model.Stage
import com.github.otr.academy.domain.repository.StageRepository

import com.github.otr.academy.spring_backend.database.dbo.StageEntity
import com.github.otr.academy.spring_backend.database.mapper.StageMapper
import com.github.otr.academy.spring_backend.repository.BaseRepository

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class StageRepositoryImpl(
    private val repository: JpaStageRepository,
    private val mapper: StageMapper
): StageRepository, BaseRepository<Stage, StageEntity>(repository, mapper) {

    override fun getStagesByProjectId(projectId: Int): List<Stage> {
        val stages: List<StageEntity> = repository.findAllByStageProject(projectId)
        return stages
            .map { mapper.mapDboToDomain(it) }
            .sortedBy { it.stageIndex }
    }

}
