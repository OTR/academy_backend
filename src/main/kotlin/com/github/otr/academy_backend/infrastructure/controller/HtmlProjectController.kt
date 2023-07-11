package com.github.otr.academy_backend.infrastructure.controller

import com.github.otr.academy_backend.domain.model.Project
import com.github.otr.academy_backend.use_case.project.GetProjectDetailsByIdUseCase
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
        model["project"] = project

        return PROJECT_DETAIL_PAGE_TEMPLATE
    }

}
