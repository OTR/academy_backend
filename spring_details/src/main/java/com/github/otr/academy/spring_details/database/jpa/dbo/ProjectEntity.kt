package com.github.otr.academy.spring_details.database.jpa.dbo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

/**
 *
 */
@Entity
@Table(name = "projects")
data class ProjectEntity(

    @Id val id: Int,

    @Column(columnDefinition = "CLOB")
    val title: String,

    @Column(columnDefinition = "CLOB")
    val description: String,

    @Column(columnDefinition = "CLOB")
    val longDescription: String,

    @OneToMany(mappedBy = "project")
    val projectTracks: List<TrackToProjectEntity>,

    val environment: String,
    val projectLanguage: String,
    val isBeta: Boolean,
    val isTemplateBased: Boolean,
    val useIde: Boolean,
    val isPublic: Boolean,
    val isIdeRequired: Boolean,
    val stagesCount: Int,
    val readiness: Int,

    )
