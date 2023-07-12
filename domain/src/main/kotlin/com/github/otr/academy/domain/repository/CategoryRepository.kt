package com.github.otr.academy.domain.repository

import com.github.otr.academy.domain.model.Category
import com.github.otr.academy.domain.model.Track

/**
 *
 */
interface CategoryRepository : GenericRepository<Category> {

    fun getAllTracksByCategoryId(categoryId: Int): List<Track>

}
