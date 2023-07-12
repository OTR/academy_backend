package com.github.otr.academy.domain.model

/**
 *
 */
data class Attempt(
    val id: Int,
    val dataset: AttemptDataset,
    val status: String,
    val step: Int,
    val time: String,
    val user: Int,
    val timeLeft: String
)
