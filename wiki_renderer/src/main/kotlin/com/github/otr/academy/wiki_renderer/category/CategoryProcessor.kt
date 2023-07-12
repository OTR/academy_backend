package com.github.otr.academy.wiki_renderer.category

import com.github.otr.academy.domain.repository.GenericRepository

import com.github.otr.academy.wiki_renderer.helper.BaseProcessor
import com.github.otr.academy.wiki_renderer.helper.TocEntity
import com.github.otr.academy.wiki_renderer.model.Category
import com.github.otr.academy.wiki_renderer.model.Track

import javax.inject.Inject

/**
 *
 */
internal class CategoryProcessor @Inject constructor(

) : BaseProcessor<Category, Track>() {

    @Inject
    override lateinit var repository: GenericRepository<Category>

    @Inject
    override lateinit var childRepository: GenericRepository<Track>

    override val isRoot: Boolean = false
    override val dirName: String = "category"
    override val childName: String = "track"

    override fun createListOfTocEntities(
        listOfChildren: List<Track>
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
