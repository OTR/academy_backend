package com.github.otr.academy.spring_details.database.jpa.dbo

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

/**
 *
 */
@Entity
@Table(name="topics")
data class TopicEntity(

    @Id val id: Int,

    val rootId: Int,
    val parentId: Int,
    val title: String,
    val rootTitle: String,
    val rootSubgroupTitle: String,
    val theory: Int,
    val depth: Int,
    val topologicalIndex: Int,
    val verificationStep: Int,
    val isDeprecated: Boolean,
    val hasSteps: Boolean,
    val isBeta: Boolean,
)
