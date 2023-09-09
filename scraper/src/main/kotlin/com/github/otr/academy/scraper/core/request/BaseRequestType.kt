package com.github.otr.academy.scraper.core.request

import com.github.otr.academy.scraper.config.Config

/**
 *
 */
internal abstract class BaseRequestType : RequestType {

    companion object {
        internal const val RELATIVE_PATH: String = ""
        internal const val PROTOCOL: String = "https"
        internal val HOST: String = Config.getHost() // TODO: Inject config
        internal const val JSON_QUERY: String = "?format=json"
    }

    abstract val id: Int

}
