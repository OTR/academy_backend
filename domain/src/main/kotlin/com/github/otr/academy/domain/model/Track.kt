package com.github.otr.academy.domain.model

/**
 * Excluded fields:
 *     val easyProjects: List<Project>,
 *     val mediumProjects: List<Project>,
 *     val hardProjects: List<Project>,
 *     val challengingProjects: List<Project>,
 *     val betaProjects: List<Project>,
 *     val capstoneProjects: List<Project>,
 *     val projectsCount: Int
 */
data class Track(
    val id: Int,
    val title: String,
    val description: String,
    val longDescription: String,

    val isBeta: Boolean,
    val isFree: Boolean,
    val isPublic: Boolean,
)
