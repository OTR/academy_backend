package com.github.otr.academy.scraper.task.page_with_steps.request

import com.github.otr.academy.scraper.cache_handler.Cacheable
import com.github.otr.academy.scraper.cache_handler.Cacheable.Companion.THREE_HUNDRED_BYTES
import com.github.otr.academy.scraper.dto.step.StepDTO

/**
 *
 */
internal data class PageWithStepsRequest(
    override val type: PageWithStepsRequestType,
    override var pathToCacheFile: String?,
    override var isCacheExists: Boolean?,
    override var sourceData: String?,
    val listOfStepDTO: List<StepDTO>,
    override val minFileLength: Long = THREE_HUNDRED_BYTES,
) : Cacheable {

    // TODO: Remove secondary constructor
    constructor(pageNumber: Int) : this(
        type = PageWithStepsRequestType(pageNumber),
        pathToCacheFile = null,
        isCacheExists = null,
        sourceData = null,
        listOfStepDTO = emptyList()
    )

}
