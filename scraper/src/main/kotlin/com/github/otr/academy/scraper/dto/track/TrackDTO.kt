package com.github.otr.academy.scraper.dto.track

import com.google.gson.annotations.SerializedName

/**
 *
 */
data class TrackDTO (

    @SerializedName("id")
    val id: Int?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("results")
    val longDescription: String?,

    @SerializedName("projects_by_level")
    val projectsByLevel: ProjectsByLevelDTO?,

    @SerializedName("beta_projects")
    val betaProjects: ArrayList<Int> = arrayListOf(),

    @SerializedName("capstone_projects")
    val capstoneProjects: ArrayList<Int> = arrayListOf(),

    @SerializedName("is_beta")
    val isBeta: Boolean?,

    @SerializedName("is_free")
    val isFree: Boolean?,

    @SerializedName("is_public")
    val isPublic: Boolean?,

    @SerializedName("seconds_to_complete")
    val secondsToComplete: Double?,

    @SerializedName("projects")
    val projects: ArrayList<Int> = arrayListOf(),

    @SerializedName("topics_count")
    val topicsCount: Int?,

    @SerializedName("can_issue_certificate")
    val canIssueCertificate: Boolean?,

    @SerializedName("cover")
    val coverUrl: String?,

    @SerializedName("capstone_topics_count")
    val capstoneTopicsCount: Int?

)
