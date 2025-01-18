package org.quickness.dynamics.di

import org.koin.core.context.startKoin

fun initKoin() = startKoin {
    printLogger()
    modules(
        ViewModelModule
    )
}