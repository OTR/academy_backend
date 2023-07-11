package com.github.otr.academy_backend.infrastructure.controller

import com.github.otr.academy_backend.domain.model.ProjectsByLevel
import com.github.otr.academy_backend.domain.model.Track
import com.github.otr.academy_backend.use_case.project.GetProjectsByLevelByTrackIdUseCase
import com.github.otr.academy_backend.use_case.track.GetTrackDetailsByIdUseCase

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

    @GetMapping(path=["/tracks/{track_id}"])
    fun getDetailTrackPage(
        @PathVariable("track_id") trackId: Int,
        model: Model
    ): String {
        val track: Track = getTrackDetailsByIdUseCase(trackId)
        val projectsByLevel: ProjectsByLevel = getProjectsByLevelByTrackIdUseCase(trackId)

        model["track"] = track
        model["easyProjects"] = projectsByLevel.easyProjects
        model["mediumProjects"] = projectsByLevel.mediumProjects
        model["hardProjects"] = projectsByLevel.hardProjects
        model["challengingProjects"] = projectsByLevel.challengingProjects
        model["betaProjects"] = projectsByLevel.betaProjects
        model["capstoneProjects"] = projectsByLevel.capstoneProjects

        return "track"
    }

}
