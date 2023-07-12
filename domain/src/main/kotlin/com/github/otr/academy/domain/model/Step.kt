package com.github.otr.academy.domain.model

/**
 * Excluded fields:
 *      val block: Block,
 *
 *
 */
data class Step(
    val id: Int,
    val title: String,
    val type: String,
    val topic: Int, // Could be nullable
    val topicTheory: Int, // Could be nullable
    val stage: Int, // Could be nullable
    val position: Int,
    val project: Int,
    val isCompleted: Boolean,
    val isBeta: Boolean,
    val isIdeCompatible: Boolean,
    val readiness: String
)
