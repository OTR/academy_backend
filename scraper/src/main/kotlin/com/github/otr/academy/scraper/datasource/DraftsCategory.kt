package data.scraper.datasource

import data.mapper.blank.TrackRequestFactory
import data.scraper.task.category.request.CategoryRequest
import data.scraper.task.category.request.CategoryRequestType

private const val DRAFTS_CATEGORY_ID: Int = 20
private const val DRAFTS_TITLE: String = "Drafts"
private const val DRAFTS_DESCRIPTION: String = "Tracks in progress"
private val TRACKS_FOR_DRAFTS_CATEGORY: ArrayList<Int> = arrayListOf(
    36, // Game development with Unity (Draft)
    43, // Go developer (Draft)
    45, // Kotlin Backend Developer (Ktor) (Draft)
    47, // Algorithmic Thinking for Developers (Draft)
    55, // Introduction to Node.js (Draft)
    60, // Introduction to MongoDB (Draft)
    61, // SQL for Data Analysis (Draft)
    63, // Natural Language Processing for ML Engineers (Draft)
    64, // Introduction to Docker (Draft)
    65, // JavaScript Core (Draft)
    66, // Introduction to Jetpack Compose for Android (Draft)
    // 69 // Introduction to Kotlin
)

/**
 * Hidden from unauthorized users Category that contains
 * beta project that are in progress, accessible but not published yet
 * only reachable from API call
 */
val DraftsCategory: CategoryRequest = CategoryRequest(
    type = CategoryRequestType(id = DRAFTS_CATEGORY_ID),
    title = DRAFTS_TITLE,
    description = DRAFTS_DESCRIPTION,
    tracks = TRACKS_FOR_DRAFTS_CATEGORY.map {trackId: Int ->
        TrackRequestFactory.getBlankTrackRequest(trackId)
    },
    isRowExists = null,
    entityFromDB = null
)
