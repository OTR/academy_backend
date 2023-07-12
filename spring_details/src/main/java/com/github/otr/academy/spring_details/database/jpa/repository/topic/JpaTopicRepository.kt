package com.github.otr.academy.spring_details.database.jpa.repository.topic

import com.github.otr.academy.spring_details.database.jpa.dbo.TopicEntity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface JpaTopicRepository : JpaRepository<TopicEntity, Int> {
}
