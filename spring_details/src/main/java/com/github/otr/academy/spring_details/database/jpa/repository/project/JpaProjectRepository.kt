package com.github.otr.academy.spring_details.database.jpa.repository.project

import com.github.otr.academy.spring_details.database.jpa.dbo.ProjectEntity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface JpaProjectRepository : JpaRepository<ProjectEntity, Int>
