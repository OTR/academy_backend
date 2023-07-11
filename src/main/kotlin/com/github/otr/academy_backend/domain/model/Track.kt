package com.github.otr.academy_backend.domain.model

/**
 *
 */
data class Track(
    val id: Int,
    val title: String,
    val description: String,
    val longDescription: String,
    val isBeta: Boolean,
    val isFree: Boolean,
    val isPublic: Boolean,
)
