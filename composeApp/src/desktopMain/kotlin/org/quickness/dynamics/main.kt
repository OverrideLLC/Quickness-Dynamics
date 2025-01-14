package org.quickness.dynamics

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Quickness Dynamics",
    ) {
        App()
    }
}