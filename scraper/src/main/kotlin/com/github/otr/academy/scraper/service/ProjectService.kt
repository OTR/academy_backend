package presentation.service

import domain.use_case.project.GetAllProjectsUseCase
import domain.use_case.GetStagesByProjectIdUseCase

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
            val stages: List<Stage> = getStagesForProjectUseCase(project)
            project.copy(stagesIds = stages.map { stage: Stage -> stage.id })
        }
        return projectsWithStages
    }

}
