package com.github.otr.academy_backend.infrastructure.repository.project

import com.github.otr.academy_backend.infrastructure.database.dbo.ProjectEntity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface JpaProjectRepository : JpaRepository<ProjectEntity, Int>
