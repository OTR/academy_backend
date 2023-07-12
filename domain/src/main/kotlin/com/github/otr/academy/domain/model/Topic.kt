package com.github.otr.academy.domain.model

/**
 * Excluded fields:
 *      val prerequisites: List<Int>,
 *      val hierarchy: List<Int>,
 *      val children: List<String>,
 *      val followers: List<Int>,
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
