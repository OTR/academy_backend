package com.github.otr.academy.scraper.dto.attempt

import com.google.gson.annotations.SerializedName

/**
 *
 */
internal data class DatasetDTO(

    @SerializedName("is_multiple_choice")
    val isMultipleChoice: Boolean?,

    @SerializedName("options")
    val options: ArrayList<String>

)
