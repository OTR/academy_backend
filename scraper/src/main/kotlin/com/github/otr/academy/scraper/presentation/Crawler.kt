package com.github.otr.academy.scraper.presentation

import com.github.otr.academy.scraper.config.Config
import com.github.otr.academy.scraper.core.task.BaseTask
import com.github.otr.academy.scraper.request_factory.ProjectRequestFactory
import com.github.otr.academy.scraper.task.project.ParseProjectTask

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.util.Stack
import javax.inject.Inject

import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.nameWithoutExtension
import kotlin.io.path.walk

/**
 *
 */
internal class Crawler @Inject constructor(
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)
) {

    companion object {
        private val HORIZONTAL_LINE: String = "_".repeat(80)
    }

    private val taskStack: Stack<BaseTask> = Stack()

    private fun getSuccessfulMessage(taskName: String): String {
        return "Task `$taskName` was processed successfully"
    }

    private fun getUnsuccessfulMessage(taskName: String): String {
        return "Task `$taskName` was NOT processed successfully"
    }

    private fun getStartingMessage(taskName: String): String {
        return "Starting to process task: `$taskName`"
    }

    private fun getEndingMessage(): String = "All tasks solved"

    fun main() {
        while (taskStack.isNotEmpty()) {
            val currentTask: BaseTask = taskStack.pop()
            val taskName: String = currentTask.fullTaskName

            logger.info(getStartingMessage(taskName))
            val (isSuccessful, furtherTasks) = currentTask.process()
            if (isSuccessful) {
                logger.info(getSuccessfulMessage(taskName))
                logger.info(HORIZONTAL_LINE)
                furtherTasks.forEach {
                    pushTask(it)
                }
            } else {
                logger.warn(getUnsuccessfulMessage(taskName))
                logger.warn(HORIZONTAL_LINE)
            }
        }
        logger.warn(getEndingMessage())
    }

    private fun pushTask(task: BaseTask) {
        taskStack.push(task)
    }

}

@OptIn(ExperimentalPathApi::class)
internal fun main() {
    val crawler = DaggerApplicationComponent.create().getCrawler()
//    crawler.pushTask(ParseCategoriesTask())
//    val practiceIds = StepRepositoryImpl.getAllPracticeStepsIds()
//
//    practiceIds.forEach {
//        crawler.addTask(
//            LoadAttemptFromRemoteTask(
//                AttemptRequest(
//                    id = it,
//                    type = AttemptRequestType(it)
//                )
//            )
//        )
//    }

    // TODO: Inject Config
    val pathToProjects = Path(Config.getPathToCacheDir())
        .resolve("api")
        .resolve("projects")

    pathToProjects.walk().forEach {
        val id = it.nameWithoutExtension.toInt()
        crawler.pushTask(
            ParseProjectTask(
                ProjectRequestFactory.getBlankProjectRequest(id).copy(isCacheExists = true)
            )
        )
    }

//    for(it in 1..1155) {
//        crawler.addTask(
//            LoadPageWithStepsTask(
//                PageWithStepsRequest(
//                    it,
//                    PageWithStepsRequestType(it)
//                )
//            )
//        )
//    }

    crawler.main()

}
