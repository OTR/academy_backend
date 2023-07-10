package com.github.otr.academy_backend.use_case

import com.github.otr.academy_backend.domain.model.Track
import com.github.otr.academy_backend.domain.repository.CategoryRepository

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
