package com.github.otr.academy.scraper.dto.track

import com.google.gson.annotations.SerializedName

/**
 *
 */
internal data class TrackContainerDTO (

    @SerializedName("tracks")
    var tracks: ArrayList<TrackDTO>

)
