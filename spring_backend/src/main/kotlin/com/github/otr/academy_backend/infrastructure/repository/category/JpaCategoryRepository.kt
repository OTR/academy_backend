package com.github.otr.academy_backend.infrastructure.repository.category

import com.github.otr.academy_backend.infrastructure.database.dbo.CategoryEntity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface JpaCategoryRepository : JpaRepository<CategoryEntity, Int>
