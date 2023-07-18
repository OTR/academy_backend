package data.scraper.task.page_with_steps

import data.scraper.cache_handler.CheckIfCacheFileExistsAndNotEmpty
import data.scraper.cache_handler.GetPathToCacheFile
import data.scraper.cache_handler.ReadSourceFromCache
import data.scraper.cache_handler.WriteSourceToCache
import data.scraper.core.task.BaseTask
import data.scraper.core.handler.Handler
import data.scraper.task.step.request.StepRequest

/**
 *
 */
class SaveStepToCacheTask(
    private val request: StepRequest
) : BaseTask {

    override val fullTaskName: String = "Save Step #${request.type.id} DTO to Step Cache file"

    override fun buildChainOfHandlers(): Handler<StepRequest> {
        val chain = GetPathToCacheFile.setNext(
            CheckIfCacheFileExistsAndNotEmpty().setNext(
                ReadSourceFromCache.setNext(
                        WriteSourceToCache
                    )
                )
            )

        return chain as Handler<StepRequest> // TODO: Remove type casts
    }

    override fun process(): Pair<Boolean, List<BaseTask>> {
        val chain: Handler<StepRequest> = buildChainOfHandlers()
        val response: StepRequest = chain(request)

        return false to emptyList()
    }

}
