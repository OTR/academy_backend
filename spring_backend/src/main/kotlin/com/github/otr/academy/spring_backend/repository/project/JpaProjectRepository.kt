package com.github.otr.academy.spring_backend.repository.project

import com.github.otr.academy.spring_backend.database.dbo.ProjectEntity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface JpaProjectRepository : JpaRepository<ProjectEntity, Int>
