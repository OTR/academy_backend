package com.github.otr.academy.scraper.dto.category

import com.google.gson.annotations.SerializedName

/**
 *
 */
internal data class CategoryDTO(

    @SerializedName("id")
    var id: Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("tracks")
    var tracks: ArrayList<Int> = arrayListOf(),

)
