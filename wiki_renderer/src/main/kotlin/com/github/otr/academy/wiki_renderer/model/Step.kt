package com.github.otr.academy.wiki_renderer.model

/**
 *
 */
internal data class Step(
    override val id: Int,
    val title: String,
    val type: String,
    val topic: Int, // Could be nullable
    val topicTheory: Int, // could be nullable
    val stage: Int, // could be nullable
    val position: Int,
    // val block: BlockDTO,
    val project: Int,
    val isCompleted: Boolean,
    val isBeta: Boolean,
    val isIdeCompatible: Boolean,
    val readiness: String
) : Identifiable
