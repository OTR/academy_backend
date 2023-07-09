package com.github.otr.academy_backend.infrastructure.repository.user

import com.github.otr.academy_backend.infrastructure.database.dbo.UserEntity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface JpaUserRepository : JpaRepository<UserEntity, Int>
