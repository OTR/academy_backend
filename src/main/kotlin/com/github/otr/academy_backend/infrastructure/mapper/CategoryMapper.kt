package com.github.otr.academy_backend.infrastructure.mapper

import com.github.otr.academy_backend.infrastructure.database.dbo.CategoryEntity
import com.github.otr.academy_backend.domain.model.Category
import com.github.otr.academy_backend.domain.model.Track

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class CategoryMapper {

    fun mapDboToDomain(dbModel: CategoryEntity): Category {
        return Category(
            id = dbModel.id,
            title = dbModel.title,
            description = dbModel.description
        )
        val x: List<Track> = dbModel.tracks.map { TrackMapper().mapDboToDomain(it) } // TODO:
    }

    fun mapDomainToDbo(entity: Category): CategoryEntity {
        return CategoryEntity(
            id = entity.id,
            tracks = emptyList(), // TODO: Fix me
            title = entity.title,
            description = entity.description
        )
    }

}
