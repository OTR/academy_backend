package com.github.otr.academy_backend.infrastructure.database.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

/**
 *
 */
@Entity
class UserModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = 0,

    val userName: String,

    val email: String,

    val password: String,

    val firstName: String,

    val accCreatedTime: LocalDate,

)
