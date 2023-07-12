package com.github.otr.academy.scraper.dto.attempt

import com.google.gson.annotations.SerializedName

/**
 *
 */
data class AttemptContainerDTO(

    @SerializedName("attempts")
    val attempts: ArrayList<AttemptDTO>

)
