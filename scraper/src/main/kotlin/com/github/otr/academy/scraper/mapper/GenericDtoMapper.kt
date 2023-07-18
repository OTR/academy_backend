package com.github.otr.academy.scraper.mapper

/**
 *
 */
interface GenericDtoMapper <T : Identifiable, S > {

    fun mapDtoToDomain(dto: S): T

}
