package com.github.otr.academy.domain.use_case.category

import com.github.otr.academy.domain.model.Category
import com.github.otr.academy.domain.repository.CategoryRepository

/**
 *
 */
class GetAllCategoriesUseCase(
    private val repository: CategoryRepository
) {

    operator fun invoke(): List<Category> {
        return repository.getAll()
    }

}
