package com.github.otr.academy.spring_details.database.jpa.mapper

import com.github.otr.academy.domain.model.User

import com.github.otr.academy.spring_details.database.jpa.dbo.UserEntity

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class UserMapper : DboMapper<User, UserEntity> {

    override fun mapDboToDomain(entity: UserEntity) = User(
        id = entity.id ?: -1,
        userName = entity.userName,
        email = entity.email,
        password = entity.password,
        firstName = entity.firstName,
        accCreatedTime = entity.accCreatedTime
    )

    override fun mapDomainToDbo(entity: User) = UserEntity(
        id = entity.id,
        userName = entity.userName,
        email = entity.email,
        password = entity.password,
        firstName = entity.firstName,
        accCreatedTime = entity.accCreatedTime
    )

}
