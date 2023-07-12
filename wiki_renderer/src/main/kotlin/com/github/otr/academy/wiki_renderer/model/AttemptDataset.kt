package com.github.otr.academy.wiki_renderer.model

/**
 *
 */
internal data class AttemptDataset(
    override val id: Int,
    val isMultipleChoice: Boolean,
    val options: ArrayList<String>
) : Identifiable
