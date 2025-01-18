package org.quickness.dynamics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.KoinContext
import org.quickness.dynamics.di.initKoin
import org.quickness.dynamics.ui.navigation.NavigationStart
import org.quickness.dynamics.ui.theme.QuicknessDynamicsTheme
import org.quickness.dynamics.ui.theme.onBackground
import org.quickness.dynamics.ui.theme.tertiary
import quicknessdynamics.composeapp.generated.resources.LogoBlancoQuickness
import quicknessdynamics.composeapp.generated.resources.Res
import quicknessdynamics.composeapp.generated.resources.check_box_outline_blank_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import quicknessdynamics.composeapp.generated.resources.close_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import quicknessdynamics.composeapp.generated.resources.remove_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24

fun main() = application {
    initKoin()
    val windowState = rememberWindowState(
        width = 1280.dp,
        height = 720.dp,
        placement = WindowPlacement.Maximized
    )
    Window(
        onCloseRequest = ::exitApplication,
        icon = painterResource(Res.drawable.LogoBlancoQuickness),
        title = "Quickness Dynamics",
        state = windowState,
        resizable = true,
        undecorated = true,
    ) {
        KoinContext {
            QuicknessDynamicsTheme {
                Column(
                    modifier = Modifier.fillMaxSize().background(onBackground),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    WindowDraggableArea(
                        windowState = windowState,
                        exitApplication = ::exitApplication,
                        frameWindowScope = this@Window
                    )
                    NavigationStart()
                }
            }
        }
    }
}

@Composable
fun WindowDraggableArea(
    windowState: WindowState,
    exitApplication: () -> Unit,
    frameWindowScope: FrameWindowScope,
) {
    frameWindowScope.WindowDraggableArea {
        Row(
            Modifier
                .fillMaxWidth()
                .height(38.dp)
                .padding(start = 8.dp)
                .background(onBackground),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(Res.drawable.LogoBlancoQuickness),
                contentDescription = "Logo",
                modifier = Modifier.height(24.dp),
                tint = tertiary
            )
            ActionButtons(
                exitApplication = exitApplication,
                windowState = windowState
            )
        }
    }
}

@Composable
fun ActionButtons(
    exitApplication: () -> Unit,
    windowState: WindowState,
) {
    Row {
        IconButton(
            onClick = {
                windowState.isMinimized = true
            },
            content = {
                Icon(
                    painter = painterResource(Res.drawable.remove_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24),
                    contentDescription = "Minimize",
                    modifier = Modifier.height(24.dp),
                    tint = tertiary
                )
            }
        )
        IconButton(
            onClick = {
                windowState.placement =
                    if (windowState.placement == WindowPlacement.Maximized)
                        WindowPlacement.Floating
                    else
                        WindowPlacement.Maximized
            },
            content = {
                Icon(
                    painter = painterResource(Res.drawable.check_box_outline_blank_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24),
                    contentDescription = "Maximize",
                    modifier = Modifier.height(24.dp),
                    tint = tertiary
                )
            }
        )
        IconButton(
            onClick = { exitApplication() },
            content = {
                Icon(
                    painter = painterResource(Res.drawable.close_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24),
                    contentDescription = "Close",
                    modifier = Modifier.height(24.dp),
                    tint = tertiary
                )
            }
        )
    }
}

