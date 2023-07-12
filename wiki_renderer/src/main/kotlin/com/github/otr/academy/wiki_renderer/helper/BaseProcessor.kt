package com.github.otr.academy.wiki_renderer.helper

import com.github.otr.academy.domain.repository.GenericRepository

import com.github.otr.academy.wiki_renderer.config.Config
import com.github.otr.academy.wiki_renderer.model.Identifiable

import kotlin.io.path.Path
import kotlin.io.path.pathString

/**
 *
 */
internal abstract class BaseProcessor<T : Identifiable, S : Identifiable> : Processor {

    companion object {

        const val ROOT_DIR_NAME: String = "jba"
        private val appDataPath: String = Config.APP_DATA_PATH
        private val wikiPagesPath: String = Path(appDataPath).resolve(ROOT_DIR_NAME).pathString

    }

    abstract override val isRoot: Boolean
    protected abstract val dirName: String
    protected abstract val childName: String
    protected abstract val repository: GenericRepository<T>
    protected abstract val childRepository: GenericRepository<S>

    override fun render() {
        val children = getChildren()
        if (isRoot) {
            createTocArticle(fileName = ROOT_DIR_NAME, listOfChildren = children)
        } else {
            val entities = getEntities()
            for (entity in entities) {
                val fileName = entity.id.toString()
                createTocArticle(fileName = fileName, listOfChildren = children)
            }

        }
    }

    abstract fun createListOfTocEntities(
        listOfChildren: List<S>
    ): Pair<String, List<TocEntity>>

    private fun createTocArticle(fileName: String, listOfChildren: List<S>) {
        val (childName, tocEntities) = createListOfTocEntities(listOfChildren)
        val rootArticle = composeTocArticle(
            childName = childName,
            tocEntities = tocEntities
        )
        val pathToFile: String = Path(wikiPagesPath)
            .resolve(dirName)
            .resolve("$fileName.txt")
            .pathString
        FileHandler.writeToFile(pathToFile = pathToFile, text = rootArticle)
    }

    private fun getChildren(): List<S> {
        return childRepository.getAll() ?: emptyList()
    }

    private fun getEntities(): List<T> {
        return repository.getAll() ?: emptyList()
    }

}
