package com.github.otr.academy.spring_backend.database.mapper

import com.github.otr.academy.domain.model.User

import com.github.otr.academy.spring_backend.controller.form.CreateUserDataForm
import com.github.otr.academy.spring_backend.database.dbo.UserEntity

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.stereotype.Component

import java.time.LocalDate

/**
 *
 */
@Component
class UserMapper : DboMapper<User, UserEntity> {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

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

    fun mapDataFormToDomain(dataForm: CreateUserDataForm): User? {
        val dataFormEmail = dataForm.email
        val dataFormFirstName = dataForm.firstName
        val dataFormUserName = dataForm.userName
        return if (
            !dataFormEmail.isNullOrBlank()
            && !dataFormFirstName.isNullOrBlank()
            && !dataFormUserName.isNullOrBlank()
        ) {
            User(
                id = User.UNDEFINED_USER_ID,
                userName = dataFormUserName,
                email = dataFormEmail,
                password = "", // TODO: Generate password
                firstName = dataFormFirstName,
                accCreatedTime = LocalDate.now()
            )
        } else {
            logger.info("Some of form fields are null")
            null
        }

    }

}
