package com.github.otr.academy.wiki_renderer.helper

import java.io.File

/**
 *
 */
internal object FileHandler {

    private fun checkIfDirExists(parentDir: File): Boolean {
        return parentDir.exists()
    }

    private fun createDirectory(parentDir: File) {
        parentDir.mkdir()
    }

    fun writeToFile(pathToFile: String, text: String) {
        val parentDir: File = File(pathToFile).parentFile
        if (checkIfDirExists(parentDir)) {
            //
        } else {
            createDirectory(parentDir)
        }
        File(pathToFile).writeText(text)

    }

}
