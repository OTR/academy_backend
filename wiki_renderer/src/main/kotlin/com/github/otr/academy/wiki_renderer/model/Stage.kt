package com.github.otr.academy.wiki_renderer.model

/**
 *
 */
internal data class Stage(
    override val id: Int,
    val title: String,
    val description: String,
    val longDescription: String,
    val language: String,
    val project: Int,
    val step: Int,
    val stagesCount: Int,
    val stageIndex: Int,
    val secondsToComplete: Double,
    val previewStep: Int,
    val allPrerequisites: List<Int>,
    val prerequisites: List<Int>,
    val isIdeRequired: Boolean,
    val previousStageId: Int
) : Identifiable
