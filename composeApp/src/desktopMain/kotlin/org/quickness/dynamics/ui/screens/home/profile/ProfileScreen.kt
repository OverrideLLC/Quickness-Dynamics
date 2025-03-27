package org.quickness.dynamics.ui.screens.home.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.quickness.dynamics.ui.components.Widget

@Composable
fun ProfileScreen() = Screen()

@Composable
private fun Screen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, start = 100.dp, end = 100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Logo()
        }
        items(4) {
            Widget(
                count = it,
                color = MaterialTheme.colorScheme.background
            )
        }
    }
}

@Composable
private fun Logo() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(200.dp)),
        content = {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                tint = MaterialTheme.colorScheme.tertiary,
                contentDescription = ""
            )
        }
    )
}