package com.github.otr.academy.scraper.config

import java.io.FileInputStream
import java.util.Properties

import kotlin.io.path.Path
import kotlin.io.path.absolutePathString

/**
 *
 */
object Config {

    private var userName: String
    private var apiKey: String
    private var databaseName: String
    private var csrfToken: String
    private var host: String

    private const val RESOURCES_PATH: String = "src/main/resources/"
    private const val APP_DATA_PATH: String = "app_data/"
    private const val PATH_TO_CONFIG_FILE: String = RESOURCES_PATH + "config.properties"
    private const val PATH_TO_CACHE_DIR: String = "cache/"
    private const val DELAY_BETWEEN_HTTP_REQUESTS_IN_MILLIS: Long = 1000
    private const val USER_AGENT: String = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36"

    private val properties: Properties = Properties()
    private val configFile: FileInputStream = FileInputStream(PATH_TO_CONFIG_FILE)

    init {
        properties.load(configFile)
        userName = properties.getProperty("user_name")
        apiKey = properties.getProperty("api_key")
        databaseName = properties.getProperty("database_name", "sample.db")
        csrfToken = properties.getProperty("csrf_token")
        host = properties.getProperty("host")
    }

    /**
     *
     */
    fun getCredentials(): Pair<String, String> = userName to apiKey

    /**
     *
     */
    fun getPathToAppData(): String = APP_DATA_PATH

    /**
     *
     */
    fun getPathToDatabase(): String {
        val absolutePath: String = Path(APP_DATA_PATH)
            .resolve(databaseName)
            .absolutePathString()
        return absolutePath
    }

    /**
     *
     */
    fun getPathToCacheDir(): String = PATH_TO_CACHE_DIR

    fun getDelayBetweenHttpRequests(): Long = DELAY_BETWEEN_HTTP_REQUESTS_IN_MILLIS

    fun getUserAgent(): String = USER_AGENT

    fun getCsrfToken(): String = csrfToken

    fun getHost(): String = host

}
