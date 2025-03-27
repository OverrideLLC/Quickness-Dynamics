package org.quickness.dynamics.ui.screens.home.settings

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.quickness.dynamics.ui.states.SettingsState

class SettingsViewModel: ViewModel() {
    private val _state = MutableStateFlow(SettingsState())
    val state = _state.asStateFlow()
    fun update(update: SettingsState.() -> SettingsState) { _state.value = update(_state.value) }
}