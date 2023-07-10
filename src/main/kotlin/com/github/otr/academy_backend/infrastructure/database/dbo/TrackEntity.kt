package com.github.otr.academy_backend.infrastructure.database.dbo

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

/**
 *
 */
@Entity
@Table(name="tracks")
data class TrackEntity(

    @Id val id: Int,

    @ManyToMany(mappedBy = "tracks")
    val categories: List<CategoryEntity>,

    val title: String,
    val description: String,
    val longDescription: String,
    val isBeta: Boolean,
    val isFree: Boolean,
    val isPublic: Boolean,
)
