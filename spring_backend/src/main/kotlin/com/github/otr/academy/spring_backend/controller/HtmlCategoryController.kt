package com.github.otr.academy.spring_backend.controller

import com.github.otr.academy.domain.model.Category
import com.github.otr.academy.domain.model.Track

import com.github.otr.academy.domain.use_case.category.GetAllCategoriesUseCase
import com.github.otr.academy.domain.use_case.category.GetTracksByCategoryIdUseCase

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
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getTracksByCategoryIdUseCase: GetTracksByCategoryIdUseCase
) {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    companion object {
        private const val ALL_TRACKS_PAGE_PATH: String = "/tracks"
        private const val ALL_TRACKS_PAGE_TEMPLATE: String = "tracks"
        private const val DEFAULT_TITLE: String = "Default Title"
        private const val TRACKS_TITLE_KEY: String = "title.tracks"
        private const val ALL_TRACKS_CATEGORY_ID: Int = 8
    }

    @GetMapping(path=[com.github.otr.academy.spring_backend.controller.HtmlCategoryController.Companion.ALL_TRACKS_PAGE_PATH])
    fun getTracksPage(
        @RequestParam(
            name = "category",
            defaultValue = com.github.otr.academy.spring_backend.controller.HtmlCategoryController.Companion.ALL_TRACKS_CATEGORY_ID.toString()
        ) categoryId: Int,
        model: Model
    ): String {
        logger.info("Category ID is: $categoryId") // TODO: Delete me

        val categories: List<Category> = getAllCategoriesUseCase()
        val currTracks: List<Track> = getTracksByCategoryIdUseCase(categoryId)

        model["title"] = environment.getProperty(
            com.github.otr.academy.spring_backend.controller.HtmlCategoryController.Companion.TRACKS_TITLE_KEY,
            com.github.otr.academy.spring_backend.controller.HtmlCategoryController.Companion.DEFAULT_TITLE
        )
        model["currCategoryId"] = categoryId
        model["categories"] = categories
        model["currTracks"] = currTracks
        return com.github.otr.academy.spring_backend.controller.HtmlCategoryController.Companion.ALL_TRACKS_PAGE_TEMPLATE
    }

}
