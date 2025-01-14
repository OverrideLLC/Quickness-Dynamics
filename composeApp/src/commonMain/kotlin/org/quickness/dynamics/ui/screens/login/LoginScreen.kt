package org.quickness.dynamics.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen() = Screen()

@Composable
private fun Screen() {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        content = { Content() },
        contentColor = Color.Transparent,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(
                        colorScheme.primary,
                        colorScheme.secondary
                    )
                )
            ),
    )
}

@Composable
private fun TopBar() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.Default.AddCircle,
            contentDescription = "Back",
            tint = colorScheme.tertiary
        )
        Text(
            text = "Quickness Dynamics",
            style = MaterialTheme.typography.titleLarge,
            color = colorScheme.tertiary
        )
    }
}

@Composable
private fun Content() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorScheme.background, shape = RoundedCornerShape(20.dp)),
        ) {
            Text(
                text = "\n" +
                        "Bienvenido de vuelta a\n" +
                        "Quickness Dynamics!\n",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Start,
                color = Color.White
            )
            Text(
                text = "Analiza las estadisticas reflejadas atravez de la aplicación de tus usuarios y trabajadores, para automatizar los procesos en tu empresa y automatización de ellos.\n" +
                        "Incluye analisis extense durante el tiempo de tus clientes, tus trabajadores, ingresos, salidas, entradas, y más...",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Start,
                color = Color.White
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = colorScheme.background.copy(.5f),
                    shape = RoundedCornerShape(20.dp)
                ),
        ) {
            Text(
                text = "Iniciar",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                color = colorScheme.tertiary
            )
            Spacer(Modifier.padding(10.dp))

        }
    }
}

@Composable
private fun BottomBar() {

}