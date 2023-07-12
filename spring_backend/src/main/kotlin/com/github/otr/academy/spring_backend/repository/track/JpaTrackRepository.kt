package com.github.otr.academy.spring_backend.repository.track

import com.github.otr.academy.spring_backend.database.dbo.TrackEntity

import org.springframework.data.jpa.repository.JpaRepository

/**
 *
 */
interface JpaTrackRepository : JpaRepository<TrackEntity, Int>
