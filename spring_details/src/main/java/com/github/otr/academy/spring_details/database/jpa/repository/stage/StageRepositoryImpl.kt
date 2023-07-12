package com.github.otr.academy.spring_details.database.jpa.repository.stage

import com.github.otr.academy.domain.model.Stage
import com.github.otr.academy.domain.repository.StageRepository

import com.github.otr.academy.spring_details.database.jpa.dbo.StageEntity
import com.github.otr.academy.spring_details.database.jpa.mapper.StageMapper
import com.github.otr.academy.spring_details.database.jpa.repository.BaseRepository

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class StageRepositoryImpl(
    private val repository: JpaStageRepository,
    private val stageMapper: StageMapper
): StageRepository, BaseRepository<Stage, StageEntity>(repository, stageMapper) {

    override fun getStagesByProjectId(projectId: Int): List<Stage> {
        val stages: List<StageEntity> = repository.findAllByStageProject(projectId)
        return stages
            .map { stageMapper.mapDboToDomain(it) }
            .sortedBy { it.stageIndex }
    }

}
