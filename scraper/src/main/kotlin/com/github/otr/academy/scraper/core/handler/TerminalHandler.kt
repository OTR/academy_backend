package data.scraper.core.handler

import data.logging.LogbackLoggerImpl_Factory
import data.logging.MyLogger
import data.scraper.core.request.CanBeRequested

/**
 * Should be the last handler in the chain of responsibility
 * Does nothing, just returns result object
 */
class TerminalHandler <T : CanBeRequested> : Handler<T> {

    override val handlerName: String = "Terminal Handler"

    override val logger: MyLogger = LogbackLoggerImpl_Factory.newInstance()

    override var next: Handler<T>
        get() = throw IllegalAccessException("Should not be called")
        set(value) {
            throw IllegalAccessException("Should not be called")
        }

    override fun setNext(handler: Handler<T>): Handler<T> {
        throw IllegalAccessException("Should not be called")
    }

    override fun canHandle(request: T): Boolean {
        throw IllegalAccessException("Should not be called")
    }

    override fun handle(request: T): T {
        throw IllegalAccessException("Should not be called")
    }

    override fun handleOrSkip(request: T): T {
        throw IllegalAccessException("Should not be called")
    }

    override fun invoke(request: T): T {
        logger.trace("Has reached the end: `$handlerName`")
        return request
    }

}
