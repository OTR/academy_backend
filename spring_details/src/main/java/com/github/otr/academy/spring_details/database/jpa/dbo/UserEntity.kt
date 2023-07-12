package com.github.otr.academy.spring_details.database.jpa.dbo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

import java.time.LocalDate

/**
 *
 */
@Entity
@Table(name = "users")
data class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = 0,

    val userName: String,
    val email: String,
    val password: String,
    val firstName: String,
    val accCreatedTime: LocalDate,
)
