package com.github.otr.academy_backend.infrastructure.repository.track

import com.github.otr.academy_backend.domain.model.Track
import com.github.otr.academy_backend.domain.repository.TrackRepository
import com.github.otr.academy_backend.infrastructure.mapper.TrackMapper

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class TrackRepositoryImpl(
    private val repository: JpaTrackRepository,
    private val mapper: TrackMapper
) : TrackRepository {

    override fun getAll(): List<Track> {
        return repository.findAll().map {
            mapper.mapDboToDomain(it)
        }
    }

    override fun getById(id: Int): Track {
        return repository.findById(id).orElseThrow().let {
            mapper.mapDboToDomain(it)
        }
    }

    override fun create(entity: Track): Track {
        return repository.save(mapper.mapDomainToDbo(entity)).let {
            mapper.mapDboToDomain(it)
        }
    }

    override fun update(entity: Track): Track {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Int) {
        repository.deleteById(id)
    }

}
