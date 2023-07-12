package com.github.otr.academy.domain.response

import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.model.Stage

/**
 * Represents a response object for Use Case of getting Project with its Stages
 */
data class ProjectWithStages(
    val project: Project,
    val stages: List<Stage>
)
