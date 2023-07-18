package com.github.otr.academy.scraper

import data.config.Config
import data.logging.MyLogger
import data.mapper.blank.ProjectRequestFactory
import data.scraper.core.task.BaseTask
import data.scraper.task.project.ParseProjectTask
import di.DaggerApplicationComponent

import java.util.Stack
import javax.inject.Inject

import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.nameWithoutExtension
import kotlin.io.path.walk

/**
 *
 */
class Crawler @Inject constructor(
    private val logger: MyLogger
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

    fun pushTask(task: BaseTask) {
        taskStack.push(task)
    }

}

@OptIn(ExperimentalPathApi::class)
fun main() {
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
