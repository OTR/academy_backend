package com.github.otr.academy.domain.response

import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.model.Stage

/**
 * Represents a response object for Use Case of getting Project with its Stages
 *
 * This response object serve as a container to deliver all the information
 * about `Project` -> `Stage`s relationship to be rendered as HTML with help
 * of template engine (e.g. Thymeleaf)
 */
data class ProjectWithStages(
    val project: Project,
    val stages: List<Stage>
)
