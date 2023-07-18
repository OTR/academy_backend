package com.github.otr.academy.scraper.core.task

import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.cache_handler.CheckIfCacheFileExistsAndNotEmpty
import com.github.otr.academy.scraper.cache_handler.GetPathToCacheFile
import com.github.otr.academy.scraper.cache_handler.ReadSourceFromCache
import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.di.ApplicationComponent

/**
 *
 */
internal abstract class BaseParseTask<T : Cacheable>(
    private val request: T
) : BaseTask {

    private val taskName = request.javaClass.simpleName
        .dropLast("Request".length)

    override val fullTaskName: String = buildString {
        append("Parse JSON with $taskName #")
        append(request.type.id)
        append(" to $taskName DTO")
    }

    private val component: ApplicationComponent = DaggerApplicationComponent.create()

    abstract val parseJsonHandler: Handler<Cacheable>

    override fun buildChainOfHandlers(): Handler<T> {
        val chain = GetPathToCacheFile().setNext(
            CheckIfCacheFileExistsAndNotEmpty().setNext(
                ReadSourceFromCache().setNext(
                    parseJsonHandler
                )
            )
        )

        return chain as Handler<T> // TODO: Remove type casts
    }

//    override fun process(): Pair<Boolean, List<com.github.otr.academy.scraper.core.task.BaseTask>> {
//        val chain: Handler<T> = buildChainOfHandlers()
//        val response: T = chain(request)
//
//        if (response.sourceData != null && response.isCacheExists != null) {
//            val klass = positiveResponse()
//            val constructor = klass.primaryConstructor
//            constructor?.let {
//                return true to listOf(it.call(response))
//            }
//        }
//        return false to emptyList()
//
//    }
//
//    abstract fun positiveResponse(): KClass<out com.github.otr.academy.scraper.core.task.BaseTask>

}
