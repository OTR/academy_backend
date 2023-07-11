package com.github.otr.academy_backend.infrastructure.repository.topic

import com.github.otr.academy_backend.infrastructure.database.dbo.TopicEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface JpaTopicRepository : JpaRepository<TopicEntity, Int> {
}
