package data.scraper.core.request

import data.config.Config

/**
 *
 */
abstract class BaseRequestType : RequestType {

    companion object {
        internal const val RELATIVE_PATH: String = ""
        internal const val PROTOCOL: String = "https"
        internal val HOST: String = Config.getHost()
        internal const val JSON_QUERY: String = "?format=json"
    }

    abstract val id: Int

}
