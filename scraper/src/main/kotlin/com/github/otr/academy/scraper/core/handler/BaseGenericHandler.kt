package data.scraper.core.handler

import data.logging.MyLogger
import data.scraper.core.request.CanBeRequested
import di.DaggerApplicationComponent

/**
 *
 */
abstract class BaseGenericHandler <T: CanBeRequested> : Handler<T> {

    companion object {

        const val ARROW: String = "                               <---------------------"
    }

    abstract override val handlerName: String

    override var logger: MyLogger = DaggerApplicationComponent.create().getLogger()

    override var next: Handler<T> = TerminalHandler()

    override fun setNext(handler: Handler<T>): Handler<T> {
        next = handler
        return this
    }

    abstract override fun canHandle(request: T): Boolean

    override fun handleOrSkip(request: T): T {
        if (canHandle(request)) {
            printPositive()

            return handle(request)

        } else {
            printNegative()

            return request
        }
    }

    abstract override fun handle(request: T): T

    fun printPositive() {
        logger.debug("Handling `$handlerName`")
    }

    fun printNegative() {
        logger.debug("Skipping `$handlerName`")
    }

    override fun invoke(request: T): T {

        val handledRequest: T = handleOrSkip(request)

        return next(handledRequest)

    }

}
