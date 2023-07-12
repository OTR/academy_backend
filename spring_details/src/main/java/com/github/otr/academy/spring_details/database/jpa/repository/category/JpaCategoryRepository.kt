package com.github.otr.academy.spring_details.database.jpa.repository.category

import com.github.otr.academy.spring_details.database.jpa.dbo.CategoryEntity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface JpaCategoryRepository : JpaRepository<CategoryEntity, Int>
