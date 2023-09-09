package com.github.otr.academy.domain.repository

/**
 *
 */
interface GenericRepository <T> {

    fun getAll(): List<T>

    fun getById(id: Int): T?

    fun save(entity: T): T

    fun saveAll(entities: List<T>)

    fun update(entity: T): T

    fun deleteById(id: Int)

}
