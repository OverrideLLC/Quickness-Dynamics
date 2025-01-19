package org.quickness.dynamics.ui.screens.home.dashboard

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DashboardViewModel : ViewModel() {
    data class WidgetItem(
        val count: Int,
        val size: Dp,
        val color: Color
    )

    data class DashboardState(
        val count: Int = 0,
        val list: MutableList<WidgetItem> = mutableListOf()
    )

    private val _state = MutableStateFlow(DashboardState())
    val state = _state.asStateFlow()

    fun update(update: DashboardState.() -> DashboardState) {
        _state.value = update(_state.value)
    }
}