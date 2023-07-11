package com.github.otr.academy_backend.domain.repository

import com.github.otr.academy_backend.domain.model.Category
import com.github.otr.academy_backend.domain.model.Track

/**
 *
 */
interface CategoryRepository : GenericRepository<Category> {

    fun getAllTracksByCategoryId(categoryId: Int): List<Track>

}
