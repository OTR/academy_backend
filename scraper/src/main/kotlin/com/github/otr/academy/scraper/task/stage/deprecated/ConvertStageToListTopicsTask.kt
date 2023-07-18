package com.github.otr.academy.scraper.task.stage.deprecated

import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.task.stage.deprecated.handler.ConvertStageToListOfTopicsHandler

/**
 *
 */
//internal class ConvertStageToListTopicsTask(
//    private val request: StageRequest
//) : com.github.otr.academy.scraper.core.task.BaseTask {
//
//    override val taskName: String = "Convert Topic To Stage"
//
//    override fun buildChainOfHandlers(): Handler<StageRequest> {
//        val chain = ConvertStageToListOfTopicsHandler
//
//        return chain
//    }
//
//    override fun process(): Pair<Boolean, List<com.github.otr.academy.scraper.core.task.BaseTask>> {
//        val chain = buildChainOfHandlers()
//        val response = chain(request)
//
//        // TODO: check
//        if (response.listOfTopics.isNotEmpty()) {
//
//        }
//        return false to emptyList()
//    }
//
//}
