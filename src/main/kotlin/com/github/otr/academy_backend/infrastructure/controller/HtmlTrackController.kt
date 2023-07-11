package com.github.otr.academy_backend.infrastructure.controller

import com.github.otr.academy_backend.domain.model.Track
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
    private val getTrackDetailsByIdUseCase: GetTrackDetailsByIdUseCase
) {

    @GetMapping(path=["/tracks/{track_id}"])
    fun getDetailTrackPage(
        @PathVariable("track_id") trackId: Int,
        model: Model
    ): String {
        val track: Track = getTrackDetailsByIdUseCase(trackId)
        model["track"] = track

        return "track"
    }

}
