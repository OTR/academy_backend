package com.github.otr.academy.spring_backend.database.mapper

import com.github.otr.academy.domain.model.Category

import com.github.otr.academy.spring_backend.database.dbo.CategoryEntity

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class CategoryMapper : DboMapper<Category, CategoryEntity> {

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
