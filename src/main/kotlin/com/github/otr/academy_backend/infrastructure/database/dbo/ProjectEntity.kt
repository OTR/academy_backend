package com.github.otr.academy_backend.infrastructure.database.dbo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
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

    val environment: String,
    val language: String,
    val isBeta: Boolean,
    val isTemplateBased: Boolean,
    val useIde: Boolean,
    val isPublic: Boolean,
    val isIdeRequired: Boolean,
    val stagesCount: Int,
    val readiness: Int,

)
