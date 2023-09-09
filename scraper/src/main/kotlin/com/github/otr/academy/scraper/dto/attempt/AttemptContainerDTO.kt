package com.github.otr.academy.scraper.dto.attempt

import com.google.gson.annotations.SerializedName

/**
 *
 */
internal data class AttemptContainerDTO(

    @SerializedName("attempts")
    val attempts: ArrayList<AttemptDTO>

)
