package com.github.otr.academy_backend.infrastructure.database.dbo

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

/**
 * TODO: No args constructor?
 */
@Entity
@Table(name = "categories")
class CategoryEntity(

    @Id
    val id: Int = 0,

    val title: String,

    val description: String

)
