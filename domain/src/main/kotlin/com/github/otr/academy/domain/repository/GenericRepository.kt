package com.github.otr.academy.domain.repository

/**
 * Defines common methods that will be used by any concrete repository
 * that would like to work with domain entities on Persistence level
 * `T` here is any type of domain entity
 */
interface GenericRepository <T> {

    fun getAll(): List<T>

    fun getById(id: Int): T?

    fun save(entity: T)

    fun saveAll(entities: List<T>)

    fun update(entity: T): T

    fun deleteById(id: Int)

}
