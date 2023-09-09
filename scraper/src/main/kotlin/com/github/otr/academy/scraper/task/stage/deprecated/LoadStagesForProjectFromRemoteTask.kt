package com.github.otr.academy.scraper.task.stage.deprecated

import com.github.otr.academy.scraper.api_handler.LoadSourceJsonHandler
import com.github.otr.academy.scraper.cache_handler.CheckIfCacheFileExistsAndNotEmpty
import com.github.otr.academy.scraper.cache_handler.GetPathToCacheFile
import com.github.otr.academy.scraper.cache_handler.ReadSourceFromCache
import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.task.stage.deprecated.request.StagesForProjectRequest

/**
 *
 */
//@Deprecated("")
//internal class LoadStabgesForProjectFromRemoteTask(
//    private val request: StagesForProjectRequest
//) : com.github.otr.academy.scraper.core.task.BaseTask {
//
//    override val taskName: String = "Load Stages for project with ID: ${request.id}"
//
//    override fun buildChainOfHandlers(): Handler<StagesForProjectRequest> {
//        val chain = GetPathToCacheFile().setNext(
//            CheckIfCacheFileExistsAndNotEmpty().setNext(
//                ReadSourceFromCache().setNext(
//                    LoadSourceJsonHandler().setNext(
//                        com.github.otr.academy.scraper.cache_handler.WriteSourceToCache
//                    )
//                )
//            )
//        )
//
//        return chain as Handler<StagesForProjectRequest>
//    }
//
//    override fun process(): Pair<Boolean, List<com.github.otr.academy.scraper.core.task.BaseTask>> {
//        val chain: Handler<StagesForProjectRequest> = buildChainOfHandlers()
//        val response: StagesForProjectRequest = chain(request)
//
//        // TODO: Check response
//        if (
//            response.isCacheExists == true
//            && response.sourceData != null
//        ) {
//            return true to listOf(
//                ParseStagesForProjectTask(
//                    request = response
//                )
//            )
//        }
//        return false to emptyList()
//    }
//
//}
