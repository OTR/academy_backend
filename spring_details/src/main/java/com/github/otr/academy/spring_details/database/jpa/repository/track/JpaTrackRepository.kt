package com.github.otr.academy.spring_details.database.jpa.repository.track

import com.github.otr.academy.spring_details.database.jpa.dbo.TrackEntity

import org.springframework.data.jpa.repository.JpaRepository

/**
 *
 */
interface JpaTrackRepository : JpaRepository<TrackEntity, Int>
