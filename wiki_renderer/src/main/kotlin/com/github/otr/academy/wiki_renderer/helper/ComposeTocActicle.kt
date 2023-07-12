package com.github.otr.academy.wiki_renderer.helper

/**
 *
 */
internal fun composeTocArticle(
    childName: String,
    tocEntities: List<TocEntity>
): String {
    var article: String = "List of $childName: \n\n"
    for (tocEntity in tocEntities) {
        article += makeH1(id = tocEntity.id, subDir = childName, title = tocEntity.title)
        article += makeBody(body = tocEntity.body)
        article += makeSeparator()
    }
    return article
}

private fun makeH1(id: Int, subDir: String, title: String): String {
    return "[[jba:$subDir:$id|[$title]]]\n\n"
}

private fun makeBody(body: String): String {
    return "$body\n\n"
}

private fun makeSeparator(): String {
    return "----\n\n"
}
