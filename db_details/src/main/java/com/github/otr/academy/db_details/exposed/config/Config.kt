package com.github.otr.academy.db_details.exposed.config

import java.io.FileInputStream
import java.util.Properties

import kotlin.io.path.Path
import kotlin.io.path.absolutePathString

/**
 *
 */
internal object Config {

    private var databaseName: String

    private const val RESOURCES_PATH: String = "src/main/resources/"
    private const val APP_DATA_PATH: String = ".app_data/"
    private const val PATH_TO_CONFIG_FILE: String = RESOURCES_PATH + "config.properties"


    private val properties: Properties = Properties()
    private val configFile: FileInputStream = FileInputStream(PATH_TO_CONFIG_FILE)

    init {
        properties.load(configFile)
        databaseName = properties.getProperty("database_name", "sample.db")
    }

    /**
     *
     */
    fun getPathToDatabase(): String {
        val absolutePath: String = Path(APP_DATA_PATH)
            .resolve(databaseName)
            .absolutePathString()
        return absolutePath
    }

}