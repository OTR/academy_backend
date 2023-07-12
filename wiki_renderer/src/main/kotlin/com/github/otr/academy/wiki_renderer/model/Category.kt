package com.github.otr.academy.wiki_renderer.model

/**
 *
 */
internal data class Category(
    override val id: Int,
    val title: String,
    val description: String,
    val tracks: List<Track>
) :  Identifiable
