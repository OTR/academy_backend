package com.github.otr.academy.scraper.dto.track

import com.google.gson.annotations.SerializedName

/**
 *
 */
data class ProjectsByLevelDTO (

    @SerializedName("easy")
    var easy: ArrayList<Int>?,

    @SerializedName("medium")
    var medium: ArrayList<Int>?,

    @SerializedName("hard")
    var hard: ArrayList<Int>?,

    @SerializedName("nightmare")
    var nightmare: ArrayList<Int>?

)
