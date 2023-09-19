package com.github.otr.academy.db_details.exposed.config

import java.io.FileInputStream
import java.util.Properties

import kotlin.io.path.Path
import kotlin.io.path.absolutePathString

/**
 * This class holds String constants, relative paths to resources
 * and filenames that would be used for database file etc
 * `RESOURCES_PATH` - path to folder that holds Java application resources
 * `APP_DATA_PATH` - path to folder that holds collected data, large files, ...
 * `PATH_TO_CONFIG_FILE` - Java Properties file that holds sensitive settings
 *                          usually project (instance) dependent
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
     * Return Absolute Path to Database that holds (or would hold) all the data
     * collected during application run
     */
    fun getPathToDatabase(): String {
        val absolutePath: String = Path(APP_DATA_PATH)
            .resolve(databaseName)
            .absolutePathString()
        return absolutePath
    }

}
