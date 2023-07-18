package di

import dagger.Binds
import dagger.Module

import data.logging.LogbackLoggerImpl
import data.logging.MyLogger

/**
 *
 */
@Module
interface LoggerModule {

    @Binds
    fun provideLogger(impl: LogbackLoggerImpl): MyLogger

}
