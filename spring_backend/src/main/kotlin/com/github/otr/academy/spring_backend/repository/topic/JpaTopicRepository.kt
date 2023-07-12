package com.github.otr.academy.spring_backend.repository.topic

import com.github.otr.academy.spring_backend.database.dbo.TopicEntity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface JpaTopicRepository : JpaRepository<TopicEntity, Int> {
}
