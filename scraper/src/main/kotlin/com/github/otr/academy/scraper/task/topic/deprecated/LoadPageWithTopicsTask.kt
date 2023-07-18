package data.scraper.task.topic.deprecated

import data.scraper.api_handler.LoadSourceJsonHandler
import data.scraper.cache_handler.CheckIfCacheFileExistsAndNotEmpty
import data.scraper.cache_handler.GetPathToCacheFile
import data.scraper.cache_handler.ReadSourceFromCache
import data.scraper.cache_handler.WriteSourceToCache
import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.cache_handler.Cacheable

import di.ApplicationComponent
import di.DaggerApplicationComponent

/**
 *
 */
class LoadPageWithTopicsTask (
    private val request: PageWithTopicsRequest
) : BaseTask {

    override val fullTaskName: String = "Load Page with Steps from Remote"

    private val component: ApplicationComponent = DaggerApplicationComponent.create()
    private val loadSourceJsonHandler: LoadSourceJsonHandler = component.__getLoadSourceJsonHandler()

    override fun buildChainOfHandlers(): Handler<Cacheable> {
        val chain = GetPathToCacheFile.setNext(
            CheckIfCacheFileExistsAndNotEmpty().setNext(
                ReadSourceFromCache.setNext(
                    loadSourceJsonHandler.setNext(
                        WriteSourceToCache
                    )
                )
            )
        )

        return chain
    }

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain = buildChainOfHandlers()
        val response = chain(request)

        // TODO: Check response
        return false to emptyList()
    }

}
