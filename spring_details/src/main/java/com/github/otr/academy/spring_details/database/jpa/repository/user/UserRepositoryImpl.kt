package com.github.otr.academy.spring_details.database.jpa.repository.user

import com.github.otr.academy.domain.model.User
import com.github.otr.academy.domain.repository.UserRepository

import com.github.otr.academy.spring_details.database.jpa.dbo.UserEntity
import com.github.otr.academy.spring_details.database.jpa.mapper.UserMapper
import com.github.otr.academy.spring_details.database.jpa.repository.BaseRepository

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class UserRepositoryImpl(
    private val repository: JpaUserRepository,
    private val mapper: UserMapper
): UserRepository, BaseRepository<User, UserEntity>(repository, mapper)
