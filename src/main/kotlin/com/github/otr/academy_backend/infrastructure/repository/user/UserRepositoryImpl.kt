package com.github.otr.academy_backend.infrastructure.repository.user

import com.github.otr.academy_backend.domain.model.User
import com.github.otr.academy_backend.domain.repository.UserRepository
import com.github.otr.academy_backend.infrastructure.database.dbo.UserEntity
import com.github.otr.academy_backend.infrastructure.mapper.user.UserMapper
import com.github.otr.academy_backend.infrastructure.repository.BaseRepository

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class UserRepositoryImpl(
    private val repository: JpaUserRepository,
    private val mapper: UserMapper
): UserRepository, BaseRepository<User, UserEntity>(repository, mapper)
