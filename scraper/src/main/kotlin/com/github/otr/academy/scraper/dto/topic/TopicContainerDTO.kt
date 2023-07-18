package com.github.otr.academy.scraper.dto.topic

import com.google.gson.annotations.SerializedName

/**
 *
 */
internal data class TopicContainerDTO(

    @SerializedName("topics")
    var topics: ArrayList<TopicDTO>

)
