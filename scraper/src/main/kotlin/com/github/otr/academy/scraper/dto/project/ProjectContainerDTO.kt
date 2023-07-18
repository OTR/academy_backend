package com.github.otr.academy.scraper.dto.project

import com.google.gson.annotations.SerializedName

/**
 *
 */
internal data class ProjectContainerDTO(

    @SerializedName("projects")
    val projects: ArrayList<ProjectDTO> = arrayListOf()

)
