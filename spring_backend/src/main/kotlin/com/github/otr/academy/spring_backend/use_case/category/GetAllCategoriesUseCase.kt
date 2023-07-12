package com.github.otr.academy.spring_backend.use_case.category

import com.github.otr.academy.domain.model.Category
import com.github.otr.academy.domain.repository.CategoryRepository

import org.springframework.stereotype.Service

/**
 *
 */
@Service
class GetAllCategoriesUseCase(
    private val repository: CategoryRepository
) {

    operator fun invoke(): List<Category> {
        return repository.getAll()
    }

}
