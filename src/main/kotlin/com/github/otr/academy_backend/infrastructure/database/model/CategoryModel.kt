package com.github.otr.academy_backend.infrastructure.database.model

import jakarta.persistence.Entity
import jakarta.persistence.Id

/**
 *
 */
@Entity
class CategoryModel(

    @Id
    val id: Int = 0,

    val title: String,

    val description: String

)
