package com.github.otr.academy_backend.infrastructure.controller

import com.github.otr.academy_backend.domain.model.Category
import com.github.otr.academy_backend.use_case.GetAllCategoriesUseCase

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.core.env.Environment
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

/**
 *
 */
@Controller
class HtmlCategoryController(
    private val environment: Environment,
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase
) {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    companion object {
        private const val DEFAULT_TITLE: String = "Default Title"
        private const val TRACKS_TITLE_KEY: String = "title.tracks"
        private const val ALL_TRACKS_CATEGORY_ID: Int = 8
    }

    @GetMapping(path=["/tracks"])
    fun getTracksPage(
        @RequestParam(
            name = "category",
            defaultValue = ALL_TRACKS_CATEGORY_ID.toString()
        ) categoryId: Int,
        model: Model
    ): String {
        logger.info("Category ID is: $categoryId") // TODO: Delete me
        model["title"] = environment.getProperty(TRACKS_TITLE_KEY, DEFAULT_TITLE)
        val categories: List<Category> = getAllCategoriesUseCase()
        model["categories"] = categories
        return "tracks"
    }

}
