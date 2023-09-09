package com.github.otr.academy.scraper.presentation

import com.github.otr.academy.scraper.di.ApplicationComponent
import com.github.otr.academy.scraper.request_factory.CategoriesRequestFactory

import com.github.otr.academy.scraper.task.categories.ParseCategoriesTask

/**
 *
 */
internal fun main(args: Array<String>) {
    val component: ApplicationComponent = DaggerApplicationComponent.create()
    val crawler = component.getCrawler()
    val initialTask = ParseCategoriesTask(
        CategoriesRequestFactory.getBlankCategoriesRequest()
    )
    crawler.pushTask(initialTask)
    crawler.main()
}
