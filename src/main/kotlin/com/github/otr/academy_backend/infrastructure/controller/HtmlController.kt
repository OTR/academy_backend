package com.github.otr.academy_backend.infrastructure.controller

import org.springframework.core.env.Environment
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

/**
 *
 */
@Controller
class HtmlController(
    private val environment: Environment,
) {

    companion object {
        private const val DEFAULT_TITLE: String = "Default Title"
        private const val INDEX_TITLE_KEY: String = "title.index"
    }

    @GetMapping(path=["/"])
    fun getIndexPage(model: Model): String {
        model["title"] = environment.getProperty(INDEX_TITLE_KEY , DEFAULT_TITLE)
        return "index"
    }

}
