package com.github.otr.academy_backend.use_case

import com.github.otr.academy_backend.domain.model.User
import com.github.otr.academy_backend.domain.repository.GenericRepository

import org.springframework.stereotype.Service

/**
 *
 */
@Service // TODO: shouldn't do it here
class GetAllUsersUseCase(
    private val repository: GenericRepository<User>
) {

    operator fun invoke(): List<User> {
        return repository.getAll()
    }

}
