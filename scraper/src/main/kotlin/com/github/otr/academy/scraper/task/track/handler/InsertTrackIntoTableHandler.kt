package data.scraper.task.track.handler

import data.mapper.dto_to_domain.GenericDtoToDomainMapper
import data.scraper.dto.track.TrackDTO
import data.scraper.task.track.request.TrackRequest
import domain.repository.GenericRepository
import javax.inject.Inject

/**
 *
 */
class InsertTrackIntoTableHandler @Inject constructor(
    private val repository: GenericRepository<Track>,
    private val mapper: GenericDtoToDomainMapper<Track, TrackDTO>
) : BaseTrackHandler() {

    override val handlerName: String = "INSERT Track INTO database"

    override fun canHandle(request: TrackRequest): Boolean {
        return request.isRowExists == false
                && request.dto != null
    }

    override fun handle(request: TrackRequest): TrackRequest {
        val trackDTO = request.dto
        if (trackDTO != null) {
            val track: Track = mapper.mapDtoToDomain(trackDTO)
            repository.save(track)
        }

        return request
    }

}
