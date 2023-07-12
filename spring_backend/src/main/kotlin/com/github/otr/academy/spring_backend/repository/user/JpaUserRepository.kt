package com.github.otr.academy.spring_backend.repository.user

import com.github.otr.academy.spring_backend.database.dbo.UserEntity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface JpaUserRepository : JpaRepository<UserEntity, Int>
