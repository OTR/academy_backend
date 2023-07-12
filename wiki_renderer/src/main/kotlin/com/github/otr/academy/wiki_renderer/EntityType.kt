package com.github.otr.academy.wiki_renderer

import com.github.otr.academy.wiki_renderer.category.CategoryProcessor
import com.github.otr.academy.wiki_renderer.helper.Processor
import com.github.otr.academy.wiki_renderer.root.RootProcessor
import com.github.otr.academy.wiki_renderer.track.TrackProcessor

/**
 *
 */
internal enum class EntityType(
    val processor: Processor
) {

    ROOT(RootProcessor()),
    CATEGORY(CategoryProcessor()),
    TRACK(TrackProcessor());

}
