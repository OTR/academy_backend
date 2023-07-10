package com.github.otr.academy_backend.infrastructure.repository.track

import com.github.otr.academy_backend.domain.model.Track
import com.github.otr.academy_backend.domain.repository.TrackRepository
import org.springframework.stereotype.Component

/**
 *
 */
@Component
class TrackRepositoryImpl(
    private val repository: JpaTrackRepository
) : TrackRepository {

    override fun getAll(): List<Track> {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): Track {
        TODO("Not yet implemented")
    }

    override fun create(entity: Track): Track {
        TODO("Not yet implemented")
    }

    override fun update(entity: Track): Track {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Int) {
        TODO("Not yet implemented")
    }
}