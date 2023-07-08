package com.github.otr.academy_backend.use_case

import com.github.otr.academy_backend.domain.model.Category
import com.github.otr.academy_backend.domain.repository.GenericRepository

import org.springframework.stereotype.Service

/**
 *
 */
@Service
class GetAllCategoriesUseCase(
    private val repository: GenericRepository<Category>
) {

    operator fun invoke(): List<Category> {
        return repository.getAll()
    }

}
