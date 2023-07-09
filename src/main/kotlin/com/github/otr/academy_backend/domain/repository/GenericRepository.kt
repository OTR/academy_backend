package com.github.otr.academy_backend.domain.repository

/**
 *
 */
interface GenericRepository <T> {

    fun getAll(): List<T>

    fun getById(id: Int): T

    fun create(entity: T): T

    fun update(entity: T): T

    fun deleteById(id: Int)

}
