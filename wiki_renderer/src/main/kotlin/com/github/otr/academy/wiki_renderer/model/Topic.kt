package com.github.otr.academy.wiki_renderer.model

/**
 *
 */
internal data class Topic(
    override val id: Int,
    val title: String,
    val rootId: Int,
    val parentId: Int,
    val rootTitle: String,
    val rootSubgroupTitle: String,
    val theory: Int,

    val prerequisites: List<Int>,
    val hierarchy: List<Int>,
    val children: List<String>,
    val followers: List<Int>,
    val depth: Int,

    val topologicalIndex: Int,
    val verificationStep: Int,

    val isDeprecated: Boolean,
    val hasSteps: Boolean,
    val isBeta: Boolean,
) : Identifiable
