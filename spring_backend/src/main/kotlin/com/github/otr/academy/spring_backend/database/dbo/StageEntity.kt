package com.github.otr.academy.spring_backend.database.dbo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

/**
 *
 */
@Entity
@Table(name="stages")
data class StageEntity (

    @Id val id: Int,

    val title: String,

    @Column(columnDefinition = "CLOB")
    val description: String,

    val stageLanguage: String,
    val stageProject: Int,
    val stageStep: Int,
    val stagesCount: Int,
    val stageIndex: Int,
    val stagePreviewStep: Int,
    val isIdeRequired: Boolean,
    val previousStageId: Int,
)
