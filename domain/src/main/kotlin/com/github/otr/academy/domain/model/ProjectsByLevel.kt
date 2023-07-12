package com.github.otr.academy.domain.model

/**
 *
 */
data class ProjectsByLevel(
    val easyProjects: List<Project>,
    val mediumProjects: List<Project>,
    val hardProjects: List<Project>,
    val challengingProjects: List<Project>,
    val betaProjects: List<Project>,
    val capstoneProjects: List<Project>
)
