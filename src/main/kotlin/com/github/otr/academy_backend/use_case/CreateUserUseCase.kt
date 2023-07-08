package com.github.otr.academy_backend.use_case

import com.github.otr.academy_backend.domain.model.User
import com.github.otr.academy_backend.domain.repository.GenericRepository

import org.springframework.stereotype.Service

/**
 *
 */
@Service // TODO: shouldn't do it here
class CreateUserUseCase(
    private val repository: GenericRepository<User>
) {

    operator fun invoke(user: User): User {
        return repository.create(user)
    }

}
