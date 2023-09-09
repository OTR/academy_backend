package com.github.otr.academy.scraper.cache_handler

import com.github.otr.academy.scraper.core.request.CanBeRequested

/**
 * @param pathToCacheFile relative path on the disk where cache file is placed
 * @param isCacheExists whether cache file exists
 * @param sourceData source data to be written to cache file
 */
internal interface Cacheable : CanBeRequested {

    companion object {
        const val ONE_HUNDRED_BYTES: Long = 100
        const val THREE_HUNDRED_BYTES: Long = 300
        const val FOUR_HUNDRED_BYTES: Long = 400
        const val FIVE_HUNDRED_BYTES: Long = 500
        const val SEVEN_HUNDRED_BYTES: Long = 700
        const val NINE_HUNDRED_BYTES: Long = 900
        const val KILOBYTE: Long = 1024
    }

    var pathToCacheFile: String?

    var isCacheExists: Boolean?

    var sourceData: String?

    val minFileLength: Long

}
