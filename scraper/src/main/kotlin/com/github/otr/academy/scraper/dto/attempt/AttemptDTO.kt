package com.github.otr.academy.scraper.dto.attempt

import com.google.gson.annotations.SerializedName

/**
 *
 */
data class AttemptDTO(

    @SerializedName("id")
    val id: Int?,

    @SerializedName("dataset")
    val dataset: DatasetDTO?,

    @SerializedName("status")
    val status: String? = null,

    @SerializedName("step")
    val step: Int?,

    @SerializedName("time")
    val time: String? = null,

    @SerializedName("user")
    val user: Int?,

    @SerializedName("time_left")
    val timeLeft: String?

)
