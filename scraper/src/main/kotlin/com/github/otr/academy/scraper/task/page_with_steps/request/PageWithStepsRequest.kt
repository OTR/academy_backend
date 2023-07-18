package data.scraper.task.page_with_steps.request

import data.scraper.dto.step.StepDTO
import data.scraper.cache_handler.Cacheable
import data.scraper.cache_handler.Cacheable.Companion.THREE_HUNDRED_BYTES

/**
 *
 */
data class PageWithStepsRequest(
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
