package data.scraper.core.handler

import data.logging.MyLogger
import data.scraper.core.request.CanBeRequested

/**
 *
 */
interface  Handler <T : CanBeRequested> {

    val handlerName: String

    val logger: MyLogger

    var next: Handler<T>

    fun canHandle(request: T): Boolean

    fun setNext(handler: Handler<T>): Handler<T>

    fun handleOrSkip(request: T): T

    fun handle(request: T): T

    operator fun invoke(request: T): T

}
