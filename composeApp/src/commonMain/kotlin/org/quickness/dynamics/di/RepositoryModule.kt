package org.quickness.dynamics.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.quickness.dynamics.repository.GeminiRepository

val RepositoryModule = module {
    singleOf(::GeminiRepository)
}