package com.github.otr.academy_backend.infrastructure.repository.track

import com.github.otr.academy_backend.infrastructure.database.dbo.TrackEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 *
 */
interface JpaTrackRepository : JpaRepository<TrackEntity, Int>
