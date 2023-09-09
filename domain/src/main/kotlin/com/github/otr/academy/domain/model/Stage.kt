package com.github.otr.academy.domain.model

/**
 * Excluded fields:
 *      val longDescription: String, - actually black for all rows
 *      val secondsToComplete: Double, - doesn't matter
 *      val allPrerequisites: List<Int>,
 *      val prerequisites: List<Int>,
 */
data class Stage(
    val id: Int,
    val title: String,
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
