package com.github.otr.academy.domain.model

/**
 *
 */
data class AttemptDataset(
    val id: Int,
    val isMultipleChoice: Boolean,
    val options: ArrayList<String>
)
