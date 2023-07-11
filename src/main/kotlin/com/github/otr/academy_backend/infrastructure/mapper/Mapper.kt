package com.github.otr.academy_backend.infrastructure.mapper

/**
 *
 */
interface Mapper <T, S> {

    fun mapDboToDomain(entity: S): T

    fun mapDomainToDbo(entity: T): S

}
