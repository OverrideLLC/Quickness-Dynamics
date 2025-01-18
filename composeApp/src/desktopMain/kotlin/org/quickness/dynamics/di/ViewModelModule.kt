package org.quickness.dynamics.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.quickness.dynamics.ui.screens.home.HomeViewModel

val ViewModelModule = module {
    viewModelOf(::HomeViewModel)
}