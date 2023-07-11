package com.github.otr.academy_backend.infrastructure.database.dbo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.Table

/**
 *
 */
@Entity
@Table(name="tracks_to_projects")
data class TrackToProjectEntity(

    @Id val id: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_id")
    val track: TrackEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    val project: ProjectEntity,

    @Column(name="project_level")
    val projectLevel: String,

)
