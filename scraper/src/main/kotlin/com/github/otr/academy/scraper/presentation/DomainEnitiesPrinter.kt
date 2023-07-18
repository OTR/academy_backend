package com.github.otr.academy.scraper.presentation

import com.github.otr.academy.domain.model.Category
import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.model.Track
import com.github.otr.academy.scraper.di.ApplicationComponent


/**
 *
 */
internal object DomainEntitiesPrinter {

    private val component: ApplicationComponent = DaggerApplicationComponent.create()
    private val categoryService = component.getCategoryService()
    private val trackService = component.getTrackService()
    private val projectService = component.getProjectService()

    fun printProjectsWithStages() {
        val projects: List<Project> = projectService.getAllProjects()
        projects.sortedBy { it.id }
            .forEach {
                println("${it.id} ${it.title} ${it.stagesIds}")
            }
    }

    fun printAllCategoriesWithTracks() {
        val categories: List<Category> = categoryService.getAllCategories()
        categories.forEach { category: Category ->
            println("${category.id} ${category.title}")
            category.tracks.forEach {
                println("\t ${it.id} ${it.title}")
            }
        }
    }

    fun printAllTracksWithProjects() {
        val tracks: List<Track> = trackService.getAllTracks()
        tracks.forEach { track: Track ->
            println("${track.id} ${track.title}")

            val easyProjects: List<Project> = track.easyProjects
            printProjectsByLevel("Easy", easyProjects)

            val mediumProjects: List<Project> = track.mediumProjects
            printProjectsByLevel("Medium", mediumProjects)

            val hardProjects: List<Project> = track.hardProjects
            printProjectsByLevel("Hard", hardProjects)

            val challengingProjects: List<Project> = track.challengingProjects
            printProjectsByLevel("Challenging", challengingProjects)

            val betaProjects: List<Project> = track.betaProjects
            printProjectsByLevel("Beta", betaProjects)

            val capstoneProjects: List<Project> = track.capstoneProjects
            printProjectsByLevel("Capstone", capstoneProjects)

            println("_".repeat(80))
        }
    }

    private fun printProjectsByLevel(level: String, projects: List<Project>) {
        println("\t $level projects for track:")
        projects.forEach { project: Project ->
            println("\t\t ${project.id} ${project.title}")
        }
    }

}

fun main() {
    DomainEntitiesPrinter.printAllTracksWithProjects()
}
