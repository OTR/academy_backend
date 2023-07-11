package com.github.otr.academy_backend.infrastructure.repository.category

import com.github.otr.academy_backend.domain.model.Category
import com.github.otr.academy_backend.domain.model.Track
import com.github.otr.academy_backend.domain.repository.CategoryRepository
import com.github.otr.academy_backend.infrastructure.database.dbo.CategoryEntity
import com.github.otr.academy_backend.infrastructure.mapper.CategoryMapper
import com.github.otr.academy_backend.infrastructure.mapper.TrackMapper
import com.github.otr.academy_backend.infrastructure.repository.BaseRepository

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class CategoryRepositoryImpl(
    private val repository: JpaCategoryRepository,
    private val mapper: CategoryMapper,
    private val trackMapper: TrackMapper
): CategoryRepository, BaseRepository<Category, CategoryEntity>(repository, mapper) {

    override fun getAllTracksByCategoryId(categoryId: Int): List<Track> {
        val category: CategoryEntity = repository.findById(categoryId).orElseThrow()
        val tracks: List<Track> = category.tracks.map {
            trackMapper.mapDboToDomain(it)
        }
        return tracks
    }

}
