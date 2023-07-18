package data.scraper.task.track

import data.scraper.core.task.BaseTask
import data.scraper.core.task.BaseLoadTask
import data.scraper.task.track.request.TrackRequest

import kotlin.reflect.KClass


/**
 *
 */
class LoadTrackFromRemoteTask(request: TrackRequest) : BaseLoadTask<TrackRequest>(request) {

    override fun positiveResponse(): KClass<out BaseTask> {
        return ParseTrackTask::class
    }

}
