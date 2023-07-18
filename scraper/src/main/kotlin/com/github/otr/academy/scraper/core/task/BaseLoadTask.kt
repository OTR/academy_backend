package data.scraper.core.task

import data.scraper.cache_handler.Cacheable
import data.scraper.cache_handler.CheckIfCacheFileExistsAndNotEmpty
import data.scraper.cache_handler.GetPathToCacheFile
import data.scraper.cache_handler.ReadSourceFromCache
import data.scraper.cache_handler.WriteSourceToCache
import data.scraper.core.handler.Handler

import di.ApplicationComponent
import di.DaggerApplicationComponent

import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

/**
 *
 */
abstract class BaseLoadTask<T : Cacheable>(
    private val request: T
) : BaseTask {

    private val taskName = request.javaClass.simpleName.dropLast("Request".length)

    override val fullTaskName: String = "Load $taskName #${request.type.id} From Remote"

    private val component: ApplicationComponent = DaggerApplicationComponent.create()

    open val loadSourceJsonHandler: Handler<Cacheable> = component.__getLoadSourceJsonHandler()

    override fun buildChainOfHandlers(): Handler<T> {
        val chain: Handler<Cacheable> = GetPathToCacheFile.setNext(
            CheckIfCacheFileExistsAndNotEmpty().setNext(
                ReadSourceFromCache.setNext(
                    loadSourceJsonHandler.setNext(
                        WriteSourceToCache
                    )
                )
            )
        )

        return chain as Handler<T> // TODO: Remove tye casts
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
