package com.github.otr.academy.scraper.task.stage.deprecated.handler

import com.github.otr.academy.scraper.dto.stage.StageDTO
import com.github.otr.academy.scraper.task.stage.handler.BaseStageHandler
import com.github.otr.academy.scraper.task.stage.request.StageRequest

/**
 *
 */
internal object ConvertStageToListOfTopicsHandler : BaseStageHandler() {

    override val handlerName: String = "Convert Stage To List Of Steps"

    override fun canHandle(request: StageRequest): Boolean {
        return request.dto != null
                && request.dto.allPrerequisites.isNotEmpty()
                && request.dto.prerequisites.isNotEmpty()
    }

    override fun handle(request: StageRequest): StageRequest {
        val stageDTO: StageDTO = request.dto ?: throw IllegalArgumentException("")
        val listOfTopics: List<Int> = request.dto.prerequisites +
                request.dto.allPrerequisites

        return request.copy(listOfTopics = listOfTopics)
    }

}
