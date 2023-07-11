package com.github.otr.academy_backend.infrastructure.database.dbo

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

/**
 * TODO: No args constructor?
 */
@Entity
@Table(name = "categories")
data class CategoryEntity(
    @Id val id: Int = 0,

    @ManyToMany
    @JoinTable(name = "categories_to_tracks") // TODO: Make Pk1 and Pk2 unique together
    val tracks: List<TrackEntity>,

    val title: String,
    val description: String,
)
