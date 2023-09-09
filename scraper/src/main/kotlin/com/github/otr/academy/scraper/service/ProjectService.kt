package com.github.otr.academy.scraper.service

import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.model.Stage
import com.github.otr.academy.domain.use_case.stage.GetStagesByProjectIdUseCase

import javax.inject.Inject

/**
 *
 */
class ProjectService @Inject constructor(
    private val getAllProjectsUseCase: GetAllProjectsUseCase,
    private val getStagesForProjectUseCase: GetStagesByProjectIdUseCase
) {

    fun getAllProjects(): List<Project> {
        val projects = getAllProjectsUseCase()
        // TODO: Move these mappings to data layer
        val projectsWithStages = projects.map { project: Project ->
            val stages: List<Stage> = getStagesForProjectUseCase(project.id)
// TODO:           project.copy(stagesIds = stages.map { stage: Stage -> stage.id })
        }
        return projectsWithStages
    }

}
