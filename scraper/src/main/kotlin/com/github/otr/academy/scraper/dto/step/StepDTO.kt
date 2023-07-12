package com.github.otr.academy.scraper.dto.step

import com.github.otr.academy.scraper.dto.step.BlockDTO
import com.github.otr.academy.scraper.dto.step.CommentsStatisticsDTO
import com.google.gson.annotations.SerializedName

/**
 *
 */
data class StepDTO(

    @SerializedName("id")
    val id: Int?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("type")
    val type: String?,

    // Could be nullable
    @SerializedName("topic")
    val topic: Int?,

    // could be nullable
    @SerializedName("topic_theory")
    val topicTheory: Int?,

    // could be nullable
    @SerializedName("stage")
    val stage: String?,

    @SerializedName("position")
    val position: Int?,

    @SerializedName("block")
    val block: BlockDTO?,

    @SerializedName("project")
    val project: String?,

    @SerializedName("comments_statistics")
    val commentsStatistics: ArrayList<CommentsStatisticsDTO>,

    @SerializedName("is_completed")
    val isCompleted: Boolean?,

    @SerializedName("is_beta")
    val isBeta: Boolean?,

    @SerializedName("is_ide_compatible")
    val isIdeCompatible: Boolean?,

    @SerializedName("readiness")
    val readiness: String?

)
