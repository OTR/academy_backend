package com.github.otr.academy.spring_backend.repository.user

import com.github.otr.academy.domain.model.User
import com.github.otr.academy.domain.repository.UserRepository

import com.github.otr.academy.spring_backend.database.dbo.UserEntity
import com.github.otr.academy.spring_backend.database.mapper.UserMapper
import com.github.otr.academy.spring_backend.repository.BaseRepository

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class UserRepositoryImpl(
    private val repository: JpaUserRepository,
    private val mapper: UserMapper
): UserRepository, BaseRepository<User, UserEntity>(repository, mapper)
