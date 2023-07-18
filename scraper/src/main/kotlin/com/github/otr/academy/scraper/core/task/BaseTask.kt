package com.github.otr.academy.scraper.core.task

/**
 *
 */
internal interface BaseTask {

    val fullTaskName: String

    fun buildChainOfHandlers(): Any

    fun process(): Pair<Boolean, List<BaseTask>>

}
