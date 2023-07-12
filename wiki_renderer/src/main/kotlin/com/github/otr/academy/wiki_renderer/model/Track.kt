package com.github.otr.academy.wiki_renderer.model

/**
 *
 */
internal data class Track(
    override val id: Int,
    val title: String,
    val description: String,
    val longDescription: String,

    val easyProjects: List<Project>,
    val mediumProjects: List<Project>,
    val hardProjects: List<Project>,
    val challengingProjects: List<Project>,
    val betaProjects: List<Project>,
    val capstoneProjects: List<Project>,

    val isBeta: Boolean,
    val isFree: Boolean,
    val isPublic: Boolean,

//    val projectsCount: Int
) : Identifiable
