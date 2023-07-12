package com.github.otr.academy.spring_details.database.jpa.repository.category

import com.github.otr.academy.domain.model.Category
import com.github.otr.academy.domain.model.Track
import com.github.otr.academy.domain.repository.CategoryRepository

import com.github.otr.academy.spring_details.database.jpa.dbo.CategoryEntity
import com.github.otr.academy.spring_details.database.jpa.mapper.CategoryMapper
import com.github.otr.academy.spring_details.database.jpa.mapper.TrackMapper
import com.github.otr.academy.spring_details.database.jpa.repository.BaseRepository

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class CategoryRepositoryImpl(
    private val repository: JpaCategoryRepository,
    private val categoryMapper: CategoryMapper,
    private val trackMapper: TrackMapper
): CategoryRepository, BaseRepository<Category, CategoryEntity>(repository, categoryMapper) {

    override fun getAllTracksByCategoryId(categoryId: Int): List<Track> {
        val category: CategoryEntity = repository.findById(categoryId).orElseThrow()
        val tracks: List<Track> = category.tracks.map {
            trackMapper.mapDboToDomain(it)
        }
        return tracks
    }

}
