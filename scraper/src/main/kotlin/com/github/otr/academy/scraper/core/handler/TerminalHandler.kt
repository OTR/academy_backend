package com.github.otr.academy.scraper.core.handler

import com.github.otr.academy.scraper.core.request.CanBeRequested

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Should be the last handler in the chain of responsibility
 * Does nothing, just returns result object
 */
internal class TerminalHandler  <T : CanBeRequested> : Handler<T> {

    override val handlerName: String = "Terminal Handler"

    override val logger: Logger = LoggerFactory.getLogger(this::class.java)

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
