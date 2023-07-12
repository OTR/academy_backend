package com.github.otr.academy.spring_backend.use_case.category

import com.github.otr.academy.domain.model.Track
import com.github.otr.academy.domain.repository.CategoryRepository

import org.springframework.stereotype.Service

/**
 *
 */
@Service
class GetTracksByCategoryIdUseCase(
    private val repository: CategoryRepository
) {

    operator fun invoke(categoryId: Int): List<Track> {
        return repository.getAllTracksByCategoryId(categoryId)
    }

}
