package data.table

import domain.model.Track

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.statements.InsertStatement

/**
 *
 */
object TracksTable : Table(name = "tracks") {
    val trackId = integer("track_id")
    val trackTitle = varchar("track_title", 255)
    val trackDescription = varchar("track_description", 1024)
    val trackLongDescription = varchar("track_long_description", 2048)

    // var easyProjects
    // mediumProjects
    // hardProjects
    // challengingProjects
    // betaProjects
    // var betaProjects: ArrayList<Int>
    // var capstoneProjects: ArrayList<String>

    val isBetaTrack = bool("is_beta_track")
    val isFreeTrack = bool("is_free_track")
    val isPublicTrack = bool("is_public_track")
//    val secondsToCompleteTrack = double("seconds_to_complete_track")
//
//    //var projects: ArrayList<Int>
//    val trackTopicsCount = integer("track_topics_count")
//    val canIssueTrackCertificate = bool("can_issue_track_certificate")
//    val trackCoverUrl = varchar("track_cover_url", 255)
//    val trackCapstoneTopicsCount = integer("tracks_capstone_topics_count")

    override val primaryKey: PrimaryKey = PrimaryKey(trackId)


    /**
     * A mapper from database row to domain entity
     */
    fun ResultRow.mapRowToTrack(): Track = Track(
        id = this[trackId],
        title = this[trackTitle],
        description = this[trackDescription],
        longDescription = this[trackLongDescription],
        easyProjects = emptyList(),
        mediumProjects = emptyList(),
        hardProjects = emptyList(),
        challengingProjects = emptyList(),
        betaProjects = emptyList(),
        capstoneProjects = emptyList(),
        isBeta = this[isBetaTrack],
        isFree = this[isFreeTrack],
        isPublic = this[isPublicTrack]
    )

    /**
     * A mapper from domain entity to database row
     */
    fun mapTrackToRow(
        statement: InsertStatement<Number>,
        track: Track
    ): InsertStatement<Number> {
        return statement.apply {
            this[trackId] = track.id
            this[trackTitle] = track.title
            this[trackDescription] = track.description
            this[trackLongDescription] = track.longDescription
            // TODO:
            this[isBetaTrack] = track.isBeta
            this[isFreeTrack] = track.isFree
            this[isPublicTrack] = track.isFree
        }
    }

}
