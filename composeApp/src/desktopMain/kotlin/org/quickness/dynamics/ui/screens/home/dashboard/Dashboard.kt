package org.quickness.dynamics.ui.screens.home.dashboard

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel
import org.quickness.dynamics.ui.components.Widget

@Composable
fun DashboardScreen() = Screen()

@Composable
fun Screen(
    viewModel: DashboardViewModel = koinViewModel()
) {
    val state = remember { viewModel.state }
    for (i in 1..100) {
        state.value.list.add(
            DashboardViewModel.WidgetItem(
                count = i,
                size = if (i % 2 == 0) 400.dp else 300.dp,
                color = colorScheme.primary.copy(alpha = 0.5f)
            )
        )
    }
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.fillMaxSize(),
        content = {
            items(state.value.list) {
                Widget(
                    count = it.count,
                    size = it.size,
                    color = it.color
                )
            }
        }
    )
}