package com.github.otr.academy_backend.domain.model

/**
 *
 */
data class Topic(
    val id: Int,
    val rootId: Int,
    val parentId: Int,
    val title: String,
    val rootTitle: String,
    val rootSubgroupTitle: String,
    val theory: Int,
    val depth: Int,
    val topologicalIndex: Int,
    val verificationStep: Int,
    val isDeprecated: Boolean,
    val hasSteps: Boolean,
    val isBeta: Boolean,
)
