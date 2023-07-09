package com.github.otr.academy_backend.infrastructure.database.dbo

import jakarta.persistence.Entity
import jakarta.persistence.Id

/**
 * TODO: No args constructor?
 */
@Entity
class CategoryEntity(

    @Id
    val id: Int = 0,

    val title: String,

    val description: String

)
