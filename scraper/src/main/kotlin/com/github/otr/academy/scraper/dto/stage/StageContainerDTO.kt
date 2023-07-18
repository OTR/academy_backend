package com.github.otr.academy.scraper.dto.stage

import com.google.gson.annotations.SerializedName

/**
 *
 */
internal data class StageContainerDTO(

    @SerializedName("stages")
    var stages: ArrayList<StageDTO>

)
