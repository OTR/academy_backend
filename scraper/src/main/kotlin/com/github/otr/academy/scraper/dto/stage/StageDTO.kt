package com.github.otr.academy.scraper.dto.stage

import com.google.gson.annotations.SerializedName

/**
 *
 */
internal data class StageDTO(

    @SerializedName("id")
    val id: Int?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("results")
    val longDescription: String?,

    @SerializedName("language")
    val language: String?,

    @SerializedName("project")
    val project: Int?,

    @SerializedName("step")
    val step: Int?,

    @SerializedName("project_stages_count")
    val projectStagesCount: Int?,

    @SerializedName("step_index")
    val stepIndex: Int?,

    @SerializedName("seconds_to_complete")
    val secondsToComplete: Double?,

    @SerializedName("preview_step")
    val previewStep: Int?,

    @SerializedName("all_prerequisites")
    val allPrerequisites: ArrayList<Int>,

    @SerializedName("prerequisites")
    val prerequisites: ArrayList<Int>,

    @SerializedName("is_ide_required")
    val isIdeRequired: Boolean?,

    @SerializedName("previous_stage_id")
    val previousStageId: String?

)
