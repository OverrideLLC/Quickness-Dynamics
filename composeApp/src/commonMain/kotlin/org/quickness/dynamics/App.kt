package org.quickness.dynamics

import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.quickness.dynamics.ui.navigation.NavigationStart
import org.quickness.dynamics.ui.theme.QuicknessDynamicsTheme

@Composable
@Preview
fun App() {
    QuicknessDynamicsTheme(
        darkTheme = true
    ) {
        NavigationStart()
    }
}