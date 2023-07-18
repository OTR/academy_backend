package presentation.service

import domain.use_case.track.GetAllTracksUseCase

import javax.inject.Inject

/**
 *
 */
class TrackService @Inject constructor(
    private val getAllTracksUseCase: GetAllTracksUseCase
) {

    fun getAllTracks(): List<Track> {
        return getAllTracksUseCase()
    }

}
