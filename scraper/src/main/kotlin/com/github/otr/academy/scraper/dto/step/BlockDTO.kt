package com.github.otr.academy.scraper.dto.step

import com.google.gson.annotations.SerializedName

/**
 *
 */
internal data class BlockDTO(

    @SerializedName("name")
    val name: String?,

    @SerializedName("text")
    val text: String?,

    @SerializedName("video")
    val video: String?,

//    @SerializedName("options")
//    val options: OptionsDTO?,

    @SerializedName("table_of_contents")
    val tableOfContents: ArrayList<TableOfContentsDTO>

)
