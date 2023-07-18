package com.github.otr.academy.scraper.task.topic.deprecated

import com.github.otr.academy.scraper.api_handler.LoadSourceJsonHandler
import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.cache_handler.CheckIfCacheFileExistsAndNotEmpty
import com.github.otr.academy.scraper.cache_handler.GetPathToCacheFile
import com.github.otr.academy.scraper.cache_handler.ReadSourceFromCache
import com.github.otr.academy.scraper.cache_handler.WriteSourceToCache
import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.di.ApplicationComponent

/**
 *
 */
internal class LoadPageWithTopicsTask (
    private val request: PageWithTopicsRequest
) : BaseTask {

    override val fullTaskName: String = "Load Page with Steps from Remote"

    private val component: ApplicationComponent = DaggerApplicationComponent.create()
    private val loadSourceJsonHandler: LoadSourceJsonHandler = component.__getLoadSourceJsonHandler()

    override fun buildChainOfHandlers(): Handler<Cacheable> {
        val chain = GetPathToCacheFile().setNext(
            CheckIfCacheFileExistsAndNotEmpty().setNext(
                ReadSourceFromCache().setNext(
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
