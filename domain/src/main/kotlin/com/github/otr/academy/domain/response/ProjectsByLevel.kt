package com.github.otr.academy.domain.response

import com.github.otr.academy.domain.model.Project

/**
 * Represents a response object for Use Case
 * of getting Projects for specific Track
 * these Projects divided by difficulty level
 */
data class ProjectsByLevel(
    val easyProjects: List<Project>,
    val mediumProjects: List<Project>,
    val hardProjects: List<Project>,
    val challengingProjects: List<Project>,
    val betaProjects: List<Project>,
    val capstoneProjects: List<Project>
)
