package com.github.otr.academy.scraperimport data.mapper.blank.CategoriesRequestFactory
import data.scraper.task.categories.ParseCategoriesTask

import di.ApplicationComponent
import di.DaggerApplicationComponent

/**
 *
 */
fun main(args: Array<String>) {
    val component: ApplicationComponent = DaggerApplicationComponent.create()
    val crawler = component.getCrawler()
    val initialTask = ParseCategoriesTask(
        CategoriesRequestFactory.getBlankCategoriesRequest()
    )
    crawler.pushTask(initialTask)
    crawler.main()
}
