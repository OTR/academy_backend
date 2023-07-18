package com.github.otr.academy.scraper.dto.topic

import com.google.gson.annotations.SerializedName

/**
 *
 */
internal data class TopicDTO(

    @SerializedName("id")
    val id: Int?,

    @SerializedName("root_id")
    val rootId: Int?,

    @SerializedName("parent_id")
    val parentId: Int?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("root_title")
    val rootTitle: String?,

    @SerializedName("root_subgroup_title")
    val rootSubgroupTitle: String?,

    @SerializedName("theory")
    val theory: Int?,

    @SerializedName("prerequisites")
    val prerequisites: ArrayList<Int> = arrayListOf(),

    @SerializedName("hierarchy")
    val hierarchy: ArrayList<Int> = arrayListOf(),

    @SerializedName("children")
    val children: ArrayList<String> = arrayListOf(),

    @SerializedName("followers")
    val followers: ArrayList<Int> = arrayListOf(),

    @SerializedName("depth")
    val depth: Int?,

    @SerializedName("topological_index")
    val topologicalIndex: Int?,

    @SerializedName("verification_step")
    val verificationStep: Int?,

    @SerializedName("is_deprecated")
    val isDeprecated: Boolean?,

    @SerializedName("has_steps")
    val hasSteps: Boolean?,

    @SerializedName("is_beta")
    val isBeta: Boolean?,

)
