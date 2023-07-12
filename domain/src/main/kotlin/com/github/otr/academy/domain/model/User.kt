package com.github.otr.academy.domain.model

import java.time.LocalDate

/**
 * TODO: Should I really add default constructor here?
 */
data class User(
    val id: Int,
    val userName: String,
    val email: String,
    val password: String,
    val firstName: String,
    val accCreatedTime: LocalDate,
) {

    companion object {
        const val UNDEFINED_USER_ID: Int = -1
    }

}
