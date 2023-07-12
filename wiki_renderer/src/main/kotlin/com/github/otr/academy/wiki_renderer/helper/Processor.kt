package com.github.otr.academy.wiki_renderer.helper

/**
 *
 */
internal interface Processor {

    val isRoot: Boolean

    fun render()

}
