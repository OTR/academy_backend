package com.github.otr.academy.wiki_renderer.root


import com.github.otr.academy.domain.repository.GenericRepository

import com.github.otr.academy.wiki_renderer.helper.BaseProcessor
import com.github.otr.academy.wiki_renderer.helper.TocEntity
import com.github.otr.academy.wiki_renderer.model.Category

import javax.inject.Inject

/**
 *
 */
internal class RootProcessor @Inject constructor(

) : BaseProcessor<Category, Category>() {

    @Inject
    override lateinit var repository: GenericRepository<Category>

    @Inject
    override lateinit var childRepository: GenericRepository<Category>

    override val isRoot: Boolean = true
    override val dirName: String = ""
    override val childName: String = "category"

    override fun createListOfTocEntities(
        listOfChildren: List<Category>
    ): Pair<String, List<TocEntity>> {
        return childName to listOfChildren.map {
            TocEntity(
                id = it.id,
                title = it.title,
                body = it.description
            )
        }
    }

}
