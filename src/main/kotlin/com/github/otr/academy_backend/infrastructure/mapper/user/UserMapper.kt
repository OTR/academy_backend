package com.github.otr.academy_backend.infrastructure.mapper.user

import com.github.otr.academy_backend.infrastructure.database.dbo.UserEntity
import com.github.otr.academy_backend.domain.model.User
import com.github.otr.academy_backend.infrastructure.controller.form.CreateUserDataForm

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.stereotype.Component
import java.time.LocalDate

/**
 *
 */
@Component
class UserMapper {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    fun mapDboToDomain(dbModel: UserEntity) = User(
        id = dbModel.id ?: -1,
        userName = dbModel.userName,
        email = dbModel.email,
        password = dbModel.password,
        firstName = dbModel.firstName,
        accCreatedTime = dbModel.accCreatedTime
    )

    fun mapDomainToDbo(entity: User) = UserEntity(
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
