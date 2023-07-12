package com.github.otr.academy.scraper.dto.step

import com.google.gson.annotations.SerializedName

/**
 *
 */
data class StepContainerDTO(

    @SerializedName("steps")
    val steps: ArrayList<StepDTO>

)
