package com.github.otr.academy.scraper.core.task

import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.cache_handler.CheckIfCacheFileExistsAndNotEmpty
import com.github.otr.academy.scraper.cache_handler.GetPathToCacheFile
import com.github.otr.academy.scraper.cache_handler.ReadSourceFromCache
import com.github.otr.academy.scraper.cache_handler.WriteSourceToCache
import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.di.ApplicationComponent

import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

/**
 *
 */
internal abstract class BaseLoadTask<T : Cacheable>(
    private val request: T
) : BaseTask {

    private val taskName = request.javaClass.simpleName.dropLast("Request".length)

    override val fullTaskName: String = "Load $taskName #${request.type.id} From Remote"

    private val component: ApplicationComponent = DaggerApplicationComponent.create()

    open val loadSourceJsonHandler: Handler<Cacheable> = component.__getLoadSourceJsonHandler()

    override fun buildChainOfHandlers(): Handler<T> {
        val chain: Handler<Cacheable> = GetPathToCacheFile().setNext(
            CheckIfCacheFileExistsAndNotEmpty().setNext(
                ReadSourceFromCache().setNext(
                    loadSourceJsonHandler.setNext(
                        WriteSourceToCache
                    )
                )
            )
        )

        return chain as Handler<T> // TODO: Remove type casts
    }

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain: Handler<T> = buildChainOfHandlers()
        val response: T = chain(request)

        if (response.sourceData != null && response.isCacheExists != null) {
            val klass = positiveResponse()
            val constructor = klass.primaryConstructor
            constructor?.let {
                return true to listOf(it.call(response))
            }
        }
        return false to emptyList()

    }

    abstract fun positiveResponse(): KClass<out BaseTask>

}
