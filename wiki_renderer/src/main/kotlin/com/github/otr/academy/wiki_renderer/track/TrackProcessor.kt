package com.github.otr.academy.wiki_renderer.track

import com.github.otr.academy.wiki_renderer.helper.BaseProcessor
import com.github.otr.academy.wiki_renderer.helper.TocEntity
import com.github.otr.academy.domain.repository.GenericRepository
import com.github.otr.academy.wiki_renderer.model.Stage
import com.github.otr.academy.wiki_renderer.model.Track

import javax.inject.Inject

/**
 *
 */
internal class TrackProcessor @Inject constructor(

) : BaseProcessor<Track, Stage>() {

    @Inject
    override lateinit var repository: GenericRepository<Track>

    @Inject
    override lateinit var childRepository: GenericRepository<Stage>

    override val isRoot: Boolean = false
    override val dirName: String = "track"
    override val childName: String = "stage"

    override fun createListOfTocEntities(
        listOfChildren: List<Stage>
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
