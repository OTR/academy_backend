package com.github.otr.academy_backend.infrastructure.repository.user

import com.github.otr.academy_backend.domain.model.User
import com.github.otr.academy_backend.domain.repository.UserRepository
import com.github.otr.academy_backend.infrastructure.mapper.user.UserMapper

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class UserRepositoryImpl(
    private val repository: JpaUserRepository,
    private val mapper: UserMapper
): UserRepository {

    override fun getAll(): List<User> {
        return repository.findAll().map {
            mapper.mapDboToDomain(it)
        }
    }

    override fun getById(id: Int): User {
        return repository.findById(id).orElseThrow().let {
            mapper.mapDboToDomain(it)
        }
    }

    override fun create(entity: User): User {
        return repository.save(mapper.mapDomainToDbo(entity)).let {
            mapper.mapDboToDomain(it)
        }
    }

    override fun update(entity: User): User {
        TODO()
    }

    override fun deleteById(id: Int) {
        repository.deleteById(id)
    }

}
