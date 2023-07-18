package com.github.otr.academy.scraper.task.stage.deprecated

import com.github.otr.academy.scraper.cache_handler.CheckIfCacheFileExistsAndNotEmpty
import com.github.otr.academy.scraper.cache_handler.GetPathToCacheFile
import com.github.otr.academy.scraper.cache_handler.ReadSourceFromCache
import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.task.stage.deprecated.handler.ParseJsonStagesForProjectHandler
import com.github.otr.academy.scraper.task.stage.deprecated.request.StagesForProjectRequest
import com.github.otr.academy.scraper.task.stage.deprecated.request.StagesForProjectRequestType

/**
 *
 */
//@Deprecated("")
//internal class ParseStagesForProjectTask(
//    private val request: StagesForProjectRequest
//    ) : BaseTask {
//
//    val taskName: String = "Parse stages for project #${request.id}"
//
//    override fun buildChainOfHandlers(): Handler<StagesForProjectRequest> {
//        val chain = GetPathToCacheFile().setNext(
//            CheckIfCacheFileExistsAndNotEmpty().setNext(
//                ReadSourceFromCache().setNext(
//                    ParseJsonStagesForProjectHandler()
//                )
//            )
//        )
//
//        return chain as Handler<StagesForProjectRequest>
//    }
//
//    override fun process(): Pair<Boolean, List<com.github.otr.academy.scraper.core.task.BaseTask>> {
//        val chain = buildChainOfHandlers()
//        val response = chain(request)
//
//        // TODO: Check response
//        if (response.stagesDTO != null && response.stagesDTO.isNotEmpty()) {
//
//            return true to response.stagesDTO.map {
//                LoadStagesForProjectFromRemoteTask(
//                    StagesForProjectRequest(
//                        id = it.id,
//                        type = StagesForProjectRequestType(stageId = it.id, stepId = it.step),
//                        stageDTO = it
//                    )
//                )
//            }
//
//        }
//        return false to emptyList()
//
//    }
//
//}
