package com.github.otr.academy.scraper.task.track

import com.github.otr.academy.scraper.core.task.BaseLoadTask
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.task.track.request.TrackRequest

import kotlin.reflect.KClass


/**
 *
 */
internal class LoadTrackFromRemoteTask(
    request: TrackRequest
) : BaseLoadTask<TrackRequest>(request) {

    override fun positiveResponse(): KClass<out BaseTask> {
        return ParseTrackTask::class
    }

}
