package com.github.otr.academy.spring_backend.controller

import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.model.Stage

import com.github.otr.academy.domain.use_case.project.GetProjectDetailsByIdUseCase
import com.github.otr.academy.domain.use_case.stage.GetStagesByProjectIdUseCase

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

/**
 *
 */
@Controller
class HtmlProjectController(
    private val getProjectDetailsByIdUseCase: GetProjectDetailsByIdUseCase,
    private val getStagesByProjectIdUseCase: GetStagesByProjectIdUseCase
) {

    companion object {
        private const val PROJECT_DETAIL_PAGE_PATH: String = "/projects"
        private const val PROJECT_DETAIL_PAGE_TEMPLATE: String = "project"
    }

    @GetMapping(path = ["$PROJECT_DETAIL_PAGE_PATH/{project_id}"])
    fun getDetailProjectPage(
        @PathVariable("project_id") projectId: Int,
        model: Model
    ): String {
        val project: Project = getProjectDetailsByIdUseCase(projectId)
        val stages: List<Stage> = getStagesByProjectIdUseCase(projectId)

        model["project"] = project
        model["stages"] = stages

        return PROJECT_DETAIL_PAGE_TEMPLATE
    }

}
