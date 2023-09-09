package com.github.otr.academy.domain.use_case.category

import com.github.otr.academy.domain.model.Track
import com.github.otr.academy.domain.repository.CategoryRepository

/**
 * For a `Category` with the given `ID` return all the `Track` objects,
 * refer to that `Category`
 * `Category` HAS-A `Track` MANY-TO-MANY Relationship
 */
class GetTracksByCategoryIdUseCase(
    private val repository: CategoryRepository
) {

    operator fun invoke(categoryId: Int): List<Track> {
        return repository.getAllTracksByCategoryId(categoryId)
    }

}
