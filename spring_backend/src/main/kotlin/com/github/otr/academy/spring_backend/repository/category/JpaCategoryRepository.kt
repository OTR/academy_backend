package com.github.otr.academy.spring_backend.repository.category

import com.github.otr.academy.spring_backend.database.dbo.CategoryEntity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface JpaCategoryRepository : JpaRepository<CategoryEntity, Int>
