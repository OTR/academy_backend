package com.github.otr.academy.wiki_renderer.model

/**
 *
 */
internal data class Attempt(
    override val id: Int,
    val dataset: AttemptDataset,
    val status: String,
    val step: Int,
    val time: String,
    val user: Int,
    val timeLeft: String
): Identifiable
