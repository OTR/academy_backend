package com.github.otr.academy.spring_backend.use_case.user

import com.github.otr.academy.domain.model.User
import com.github.otr.academy.domain.repository.UserRepository

import org.springframework.stereotype.Service

/**
 *
 */
@Service // TODO: shouldn't do it here
class CreateUserUseCase(
    private val repository: UserRepository
) {

    operator fun invoke(user: User): User {
        return repository.create(user)
    }

}
