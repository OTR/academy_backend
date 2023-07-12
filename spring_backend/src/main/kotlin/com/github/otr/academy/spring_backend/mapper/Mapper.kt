package com.github.otr.academy.spring_backend.mapper

/**
 *
 */
interface Mapper <T, S> {

    fun mapDboToDomain(entity: S): T

    fun mapDomainToDbo(entity: T): S

}
