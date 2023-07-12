package com.github.otr.academy.spring_details.database.jpa.repository.user

import com.github.otr.academy.spring_details.database.jpa.dbo.UserEntity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface JpaUserRepository : JpaRepository<UserEntity, Int>
