package com.github.otr.academy.scraper.task.page_with_steps

import com.github.otr.academy.scraper.cache_handler.CheckIfCacheFileExistsAndNotEmpty
import com.github.otr.academy.scraper.cache_handler.GetPathToCacheFile
import com.github.otr.academy.scraper.cache_handler.ReadSourceFromCache
import com.github.otr.academy.scraper.cache_handler.WriteSourceToCache
import com.github.otr.academy.scraper.core.handler.Handler
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.task.step.request.StepRequest

/**
 *
 */
internal class SaveStepToCacheTask(
    private val request: StepRequest
) : BaseTask {

    override val fullTaskName: String = "Save Step #${request.type.id} DTO to Step Cache file"

    override fun buildChainOfHandlers(): Handler<StepRequest> {
        val chain = GetPathToCacheFile().setNext(
            CheckIfCacheFileExistsAndNotEmpty().setNext(
                ReadSourceFromCache().setNext(
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
