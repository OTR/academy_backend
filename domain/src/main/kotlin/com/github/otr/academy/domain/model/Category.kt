package com.github.otr.academy.domain.model

/**
 * Excluded fields:
 *      val tracks: List<Track>
 */
data class Category(
    val id: Int,
    val title: String,
    val description: String
)
