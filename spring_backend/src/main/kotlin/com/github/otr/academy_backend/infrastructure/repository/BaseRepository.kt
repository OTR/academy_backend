package com.github.otr.academy_backend.infrastructure.repository

import com.github.otr.academy_backend.domain.repository.GenericRepository
import com.github.otr.academy_backend.infrastructure.mapper.Mapper

import org.springframework.data.jpa.repository.JpaRepository

/**
 *
 */
abstract class BaseRepository <T, S : Any> (
    private val repository: JpaRepository<S, Int>,
    private val mapper: Mapper<T, S>,
): GenericRepository<T> {

    override fun getAll(): List<T> {
        return repository.findAll().map {
            mapper.mapDboToDomain(it)
        }
    }

    override fun getById(id: Int): T {
        return repository.findById(id).orElseThrow().let {
            mapper.mapDboToDomain(it)
        }
    }

    override fun create(entity: T): T {
        return repository.save(mapper.mapDomainToDbo(entity)).let {
            mapper.mapDboToDomain(it)
        }
    }

    override fun update(entity: T): T {
        TODO()
    }

    override fun deleteById(id: Int) {
        repository.deleteById(id)
    }

}
