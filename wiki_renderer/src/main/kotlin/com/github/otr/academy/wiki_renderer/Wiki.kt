package com.github.otr.academy.wiki_renderer

/**
 *
 */
internal class Wiki {

    fun render() {
        for (entity in EntityType.values()) {
            entity.processor.render()
        }
    }

}

fun main() {
    val wiki: Wiki = Wiki()
    wiki.render()
}
