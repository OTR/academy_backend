package data.table

import domain.model.Attempt
import domain.model.AttemptDataset

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.statements.InsertStatement

/**
 *
 */
object AttemptsTable : Table(name = "attempts"){
    val attemptId = integer("attempt_id")
    val attemptStatus = varchar("attempt_status", 255)
    val attemptStep = integer("attempt_step")
    val attemptTime = varchar("attempt_time", 255)
    val attemptUser = integer("attempt_user")
    val attemptTimeLeft = varchar("attempt_time_left", 255)

    override val primaryKey: PrimaryKey = PrimaryKey(attemptId)

//    val attemptDataset = ForeignKeyConstraint(
//        references = mapOf(attemptId to StepsTable.stepId),
//        onUpdate = ReferenceOption.CASCADE,
//        onDelete = ReferenceOption.CASCADE,
//        name = "attempt_dataset"
//    )

    /**
     * A mapper from database row to domain entity
     */
    fun ResultRow.mapRowToAttempt(): Attempt = Attempt(
        id = this[attemptId],
//        dataset = this[attemptDataset.].mapRowToStep(),
        dataset = AttemptDataset(-1, false, arrayListOf()),
        status = this[attemptStatus],
        step = this[attemptStep],
        time = this[attemptTime],
        user = this[attemptUser],
        timeLeft = this[attemptTimeLeft],
    )

    /**
     * A mapper from domain entity to database row
     */
    fun mapAttemptToRow(
        statement: InsertStatement<Number>,
        attempt: Attempt
    ): InsertStatement<Number> {
        return statement.apply {
            this[attemptId] = attempt.id
            this[attemptStatus] = attempt.status
            this[attemptStep] = attempt.step
            this[attemptTime] = attempt.time
            this[attemptUser] = attempt.user
            this[attemptTimeLeft] = attempt.timeLeft
        }
    }

}
