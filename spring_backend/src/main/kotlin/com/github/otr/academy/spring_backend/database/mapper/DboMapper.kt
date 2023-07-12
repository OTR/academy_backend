package com.github.otr.academy.spring_backend.database.mapper

/**
 *
 */
interface DboMapper <T, S> {

    fun mapDboToDomain(entity: S): T

    fun mapDomainToDbo(entity: T): S

}
