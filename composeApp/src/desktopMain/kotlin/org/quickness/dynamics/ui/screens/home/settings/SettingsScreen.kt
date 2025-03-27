package org.quickness.dynamics.ui.screens.home.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel
import org.quickness.dynamics.ui.components.Widget

@Composable
fun SettingsScreen() = Screen()

@Composable
private fun Screen(viewModel: SettingsViewModel = koinViewModel()) {
    val state by remember { viewModel.state }.collectAsState()
    Content()
}

@Composable
private fun Content() {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(10.dp),
        modifier = Modifier.fillMaxSize().background(Color.Transparent),
        content = {
            items(100) {
                Widget(
                    count = it,
                    size = 300.dp,
                    color = colorScheme.primary.copy(alpha = 0.5f)
                )
            }
        }
    )
}