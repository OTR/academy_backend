package com.github.otr.academy.domain.use_case.user

import com.github.otr.academy.domain.model.User
import com.github.otr.academy.domain.repository.UserRepository

/**
 * Return all the `User` entities from persistence level
 */
class GetAllUsersUseCase(
    private val repository: UserRepository
) {

    operator fun invoke(): List<User> {
        return repository.getAll()
    }

}
