package com.github.otr.academy.domain.use_case.user

import com.github.otr.academy.domain.model.User
import com.github.otr.academy.domain.repository.UserRepository

/**
 *
 */
class CreateUserUseCase(
    private val repository: UserRepository
) {

    operator fun invoke(user: User): User {
        return repository.save(user)
    }

}
