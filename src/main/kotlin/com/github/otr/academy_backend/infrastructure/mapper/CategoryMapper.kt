package com.github.otr.academy_backend.infrastructure.mapper

import com.github.otr.academy_backend.infrastructure.database.model.CategoryModel
import com.github.otr.academy_backend.domain.model.Category

/**
 *
 */
class CategoryMapper {

    fun mapDbModelToDomain(dbModel: CategoryModel): Category {
        return Category(
            id = dbModel.id,
            title = dbModel.title,
            description = dbModel.description
        )
    }

    fun mapDomainToDbModel(entity: Category): CategoryModel {
        return CategoryModel(
            id = entity.id,
            title = entity.title,
            description = entity.description
        )
    }

}
