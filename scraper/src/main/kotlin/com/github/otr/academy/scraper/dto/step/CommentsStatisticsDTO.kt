package com.github.otr.academy.scraper.dto.step

import com.google.gson.annotations.SerializedName

/**
 *
 */
data class CommentsStatisticsDTO(

    @SerializedName("thread")
    var thread: String?,

    @SerializedName("total_count")
    var totalCount: Int?

)
