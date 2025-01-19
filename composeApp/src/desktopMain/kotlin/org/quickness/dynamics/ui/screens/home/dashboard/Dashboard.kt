package org.quickness.dynamics.ui.screens.home.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.compose.viewmodel.koinViewModel

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

@Composable
private fun Widget(
    count: Int,
    size: Dp = 200.dp,
    color: Color
) {
    Box(
        modifier = Modifier
            .size(size)
            .padding(8.dp)
            .background(color),
        contentAlignment = Alignment.Center,
        content = {
            Text(
                text = count.toString(),
                color = colorScheme.background,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        }
    )
}