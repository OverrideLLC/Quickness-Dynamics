package org.quickness.dynamics.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoinCommon(
    appDeclaration: KoinAppDeclaration? = null
) = startKoin {
    appDeclaration?.invoke(this)
    modules(
        NativeModule,
    )
}