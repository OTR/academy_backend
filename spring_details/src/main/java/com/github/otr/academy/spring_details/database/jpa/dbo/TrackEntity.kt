package com.github.otr.academy.spring_details.database.jpa.dbo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany
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

    @OneToMany(mappedBy = "track")
    val trackProjects: List<TrackToProjectEntity>,

    @Column(columnDefinition = "CLOB")
    val title: String,

    @Column(columnDefinition = "CLOB")
    val description: String,

    @Column(columnDefinition = "CLOB")
    val longDescription: String,

    val isBeta: Boolean,
    val isFree: Boolean,
    val isPublic: Boolean,
)
