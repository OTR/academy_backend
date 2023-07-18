package com.github.otr.academy.scraper.core.handler

import com.github.otr.academy.scraper.core.request.CanBeRequested
import org.slf4j.Logger

/**
 *
 */
internal interface  Handler <T : CanBeRequested> {

    val handlerName: String

    val logger: Logger

    var next: Handler<T>

    fun canHandle(request: T): Boolean

    fun setNext(handler: Handler<T>): Handler<T>

    fun handleOrSkip(request: T): T

    fun handle(request: T): T

    operator fun invoke(request: T): T

}
