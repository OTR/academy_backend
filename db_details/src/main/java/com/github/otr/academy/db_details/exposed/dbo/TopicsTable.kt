package com.github.otr.academy.db_details.exposed.dbo

import com.github.otr.academy.domain.model.Topic

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.statements.InsertStatement

/**
 * Excluded fields:
 *      val isBeta: Boolean,
 */
internal object TopicsTable: Table(name = "topics") {
    val topicId = integer("topic_id")
    val topicRootId = integer("topic_root_id")
    val topicParentId = integer("topic_parent_id")

    val topicTitle = varchar("topic_title", 255)
    val topicRootTitle = varchar("topic_root_title", 255)
    val topicRootSubgroupTitle = varchar("topic_root_subgroup_title", 255)

    val topicTheory = integer("topic_theory")

    val topicDepth = integer("topic_depth")
    val topicsTopologicalIndex = integer("topic_topological_index")
    val topicVerificationStep = integer("topic_verification_step")

    val isDeprecatedTopic = bool("is_deprecated_topic")
    val hasStepsTopic = bool("has_steps_topic")
    val isBetaTopic = bool("is_beta_topic")

    override val primaryKey: PrimaryKey = PrimaryKey(topicId)

    /**
     * A mapper from database row to domain entity
     */
    fun ResultRow.mapRowToTopic(): Topic = Topic(
        id = this[topicId],
        rootId = this[topicRootId],
        parentId = this[topicParentId],

        title = this[topicTitle],
        rootTitle = this[topicRootTitle],
        rootSubgroupTitle = this[topicRootSubgroupTitle],

//        prerequisites = emptyList(), // TODO:
//        hierarchy = emptyList(),
//        children = emptyList(),
//        followers = emptyList(),

        theory = this[topicTheory],
        depth = this[topicDepth],
        topologicalIndex = this[topicsTopologicalIndex],
        verificationStep = this[topicVerificationStep],

        isDeprecated = this[isDeprecatedTopic],
        hasSteps = this[hasStepsTopic],
        isBeta = this[isBetaTopic],

    )

    /**
     * A mapper from domain entity to database row
     */
    fun mapTopicToRow(
        statement: InsertStatement<Number>,
        topic: Topic
    ): InsertStatement<Number> {
        return statement.apply {
            this[topicId] = topic.id
            this[topicRootId] = topic.rootId
            this[topicParentId] = topic.parentId

            this[topicTitle] = topic.title
            this[topicRootTitle] = topic.rootTitle
            this[topicRootSubgroupTitle] = topic.rootSubgroupTitle

            this[topicTheory] = topic.theory

            this[topicDepth] = topic.depth
            this[topicsTopologicalIndex] = topic.topologicalIndex
            this[topicVerificationStep] = topic.verificationStep

            this[isDeprecatedTopic] = topic.isDeprecated
            this[hasStepsTopic] = topic.hasSteps
            this[isBetaTopic] = topic.isBeta
        }
    }

}
