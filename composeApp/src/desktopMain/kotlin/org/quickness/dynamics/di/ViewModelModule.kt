package org.quickness.dynamics.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.quickness.dynamics.ui.screens.home.HomeViewModel
import org.quickness.dynamics.ui.screens.home.ai.AiViewModel
import org.quickness.dynamics.ui.screens.home.dashboard.DashboardViewModel
import org.quickness.dynamics.ui.screens.home.settings.SettingsViewModel

val ViewModelModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::DashboardViewModel)
    viewModelOf(::AiViewModel)
    viewModelOf(::SettingsViewModel)
}