package com.github.otr.academy.spring_backend.controller

import com.github.otr.academy.domain.response.ProjectsByLevel
import com.github.otr.academy.domain.model.Track

import com.github.otr.academy.domain.use_case.track.GetProjectsByLevelByTrackIdUseCase
import com.github.otr.academy.domain.use_case.track.GetTrackDetailsByIdUseCase

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

/**
 *
 */
@Controller
class HtmlTrackController(
    private val getTrackDetailsByIdUseCase: GetTrackDetailsByIdUseCase,
    private val getProjectsByLevelByTrackIdUseCase: GetProjectsByLevelByTrackIdUseCase
) {

    companion object {
        private const val TRACK_DETAIL_PAGE_PATH: String = "/tracks"
        private const val TRACK_DETAIL_PAGE_TEMPLATE: String = "track"
    }

    @GetMapping(path=["$TRACK_DETAIL_PAGE_PATH/{track_id}"])
    fun getDetailTrackPage(
        @PathVariable("track_id") trackId: Int,
        model: Model
    ): String {
        val track: Track? = getTrackDetailsByIdUseCase(trackId)
        val projectsByLevel: ProjectsByLevel = getProjectsByLevelByTrackIdUseCase(trackId)

        // FIXME:
        if (track != null) {
            model["track"] = track
            model["easyProjects"] = projectsByLevel.easyProjects
            model["mediumProjects"] = projectsByLevel.mediumProjects
            model["hardProjects"] = projectsByLevel.hardProjects
            model["challengingProjects"] = projectsByLevel.challengingProjects
            model["betaProjects"] = projectsByLevel.betaProjects
            model["capstoneProjects"] = projectsByLevel.capstoneProjects
        }

        return TRACK_DETAIL_PAGE_TEMPLATE
    }

}
