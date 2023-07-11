package com.github.otr.academy_backend.infrastructure.mapper

import com.github.otr.academy_backend.infrastructure.database.dbo.CategoryEntity
import com.github.otr.academy_backend.domain.model.Category

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class CategoryMapper : Mapper<Category, CategoryEntity> {

    override fun mapDboToDomain(entity: CategoryEntity): Category {
        return Category(
            id = entity.id,
            title = entity.title,
            description = entity.description
        )
    }

    override fun mapDomainToDbo(entity: Category): CategoryEntity {
        return CategoryEntity(
            id = entity.id,
            tracks = emptyList(), // TODO: Fix me
            title = entity.title,
            description = entity.description
        )
    }

}
