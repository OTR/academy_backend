package com.github.otr.academy_backend.infrastructure.controller

import com.github.otr.academy_backend.domain.model.Category
import com.github.otr.academy_backend.use_case.GetAllCategoriesUseCase

import org.springframework.core.env.Environment
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

/**
 *
 */
@Controller
class HtmlCategoryController(
    private val environment: Environment,
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase
) {

    companion object {
        private const val DEFAULT_TITLE: String = "Default Title"
        private const val TRACKS_TITLE_KEY: String = "title.tracks"
    }

    @GetMapping(path=["/tracks"])
    fun getTracksPage(model: Model): String {
        model["title"] = environment.getProperty(
            TRACKS_TITLE_KEY,
            DEFAULT_TITLE
        )
        val categories: List<Category> = getAllCategoriesUseCase()
        model["categories"] = categories
        return "tracks"
    }

}
