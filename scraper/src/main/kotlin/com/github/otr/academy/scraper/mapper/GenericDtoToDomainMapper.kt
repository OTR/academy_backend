package com.github.otr.academy.scraper.mapper

import domain.model.Identifiable

/**
 *
 */
interface GenericDtoToDomainMapper <T : Identifiable, S > {

    fun mapDtoToDomain(dto: S): T

}
