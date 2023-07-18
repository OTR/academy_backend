package data.scraper.core.task

/**
 *
 */
interface BaseTask {

    val fullTaskName: String

    fun buildChainOfHandlers(): Any

    fun process(): Pair<Boolean, List<BaseTask>>

}
