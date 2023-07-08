package com.github.otr.academy_backend.infrastructure.repository

import com.github.otr.academy_backend.domain.model.User
import com.github.otr.academy_backend.domain.repository.GenericRepository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface JpaUserRepository
    : JpaRepository<User, Int>, GenericRepository<User>
