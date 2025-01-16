package org.quickness.dynamics

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import org.jetbrains.compose.resources.painterResource
import quicknessdynamics.composeapp.generated.resources.LogoBlancoQuickness
import quicknessdynamics.composeapp.generated.resources.Res

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        icon = painterResource(Res.drawable.LogoBlancoQuickness),
        title = "Quickness Dynamics",
        state = WindowState(
            width = 1280.dp,
            height = 720.dp,
            placement = WindowPlacement.Maximized
        )
    ) {
        App()
    }
}