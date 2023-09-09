package com.github.otr.academy.domain.response

import com.github.otr.academy.domain.model.Project

/**
 * Represents a response object for Use Case
 * of getting Projects for specific Track
 * these Projects divided by difficulty level
 *
 * This response object serve as a container to deliver all the information
 * about `Track` -> `Project`s relationship to be rendered as HTML with help
 * of template engine (e.g. Thymeleaf)
 */
data class ProjectsByLevel(
    val easyProjects: List<Project>,
    val mediumProjects: List<Project>,
    val hardProjects: List<Project>,
    val challengingProjects: List<Project>,
    val betaProjects: List<Project>,
    val capstoneProjects: List<Project>
)
