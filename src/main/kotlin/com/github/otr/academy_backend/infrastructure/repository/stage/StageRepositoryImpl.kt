package com.github.otr.academy_backend.infrastructure.repository.stage

import com.github.otr.academy_backend.domain.model.Stage
import com.github.otr.academy_backend.domain.repository.StageRepository
import com.github.otr.academy_backend.infrastructure.database.dbo.StageEntity
import com.github.otr.academy_backend.infrastructure.mapper.StageMapper
import com.github.otr.academy_backend.infrastructure.repository.BaseRepository

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
