package org.quickness.dynamics.di

import org.koin.core.context.startKoin
import org.koin.core.logger.Level

fun initKoin() = startKoin {
    printLogger(Level.DEBUG)
    modules(
        ViewModelModule,
        RepositoryModule,
        ServiceModule
    )
}