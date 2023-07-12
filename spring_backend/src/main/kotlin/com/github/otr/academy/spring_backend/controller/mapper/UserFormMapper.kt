package com.github.otr.academy.spring_backend.controller.mapper

import com.github.otr.academy.domain.model.User

import com.github.otr.academy.spring_backend.controller.form.CreateUserDataForm

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.stereotype.Component

import java.time.LocalDate

/**
 *
 */
@Component
class UserFormMapper {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

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
