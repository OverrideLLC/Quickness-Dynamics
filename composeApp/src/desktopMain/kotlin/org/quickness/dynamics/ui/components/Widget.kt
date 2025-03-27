package org.quickness.dynamics.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Widget(
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