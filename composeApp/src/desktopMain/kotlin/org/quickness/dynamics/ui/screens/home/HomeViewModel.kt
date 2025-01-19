package org.quickness.dynamics.ui.screens.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.jetbrains.compose.resources.DrawableResource
import org.quickness.dynamics.ui.states.HomeState

class HomeViewModel : ViewModel() {
    data class IconsBottomBar(
        val route: String,
        val icon: DrawableResource
    )

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    fun update(update: HomeState.() -> HomeState) {
        _state.value = update(_state.value)
    }
}