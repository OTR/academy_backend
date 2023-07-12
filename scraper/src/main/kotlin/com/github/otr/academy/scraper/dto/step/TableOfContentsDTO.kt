package com.github.otr.academy.scraper.dto.step

import com.google.gson.annotations.SerializedName

/**
 *
 */
data class TableOfContentsDTO(

    @SerializedName("id")
    val id: String?,

    @SerializedName("title")
    val title: String?
)
