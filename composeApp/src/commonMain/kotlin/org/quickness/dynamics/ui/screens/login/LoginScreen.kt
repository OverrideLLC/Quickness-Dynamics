package org.quickness.dynamics.ui.screens.login

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.quickness.dynamics.plataform.Uri
import qrgenerator.qrkitpainter.rememberQrKitPainter

@Composable
fun LoginScreen() = Screen()

@Composable
private fun Screen() {
    val infiniteTransition = rememberInfiniteTransition()
    val color1 by infiniteTransition.animateColor(
        initialValue = colorScheme.background,
        targetValue = colorScheme.background,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val color2 by infiniteTransition.animateColor(
        initialValue = colorScheme.background,
        targetValue = colorScheme.primary,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 4000, easing = LinearEasing, delayMillis = 1000),
            repeatMode = RepeatMode.Reverse
        )
    )
    Scaffold(
        content = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Content()
            }
        },
        containerColor = Color.Transparent,
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(listOf(color1, color2))),
    )
}

@Composable
private fun Content() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
            .background(
                color = colorScheme.onBackground.copy(alpha = 0.6f),
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            InfoContent()
            Spacer(modifier = Modifier.padding(16.dp))
            QrContent()
        }
    }
}

@Composable
private fun QrContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = rememberQrKitPainter(data = "NJ2N93N293N23U92N3U23N92N3NU239N239U2N3.2I3M293MI23923M29NU3U293.2M93I2N932N39N323NU923"),
            contentDescription = "Código QR",
            modifier = Modifier
                .size(300.dp),
            tint = Color.White
        )
        Text(
            text = "Escanea el código QR para iniciar sesión.",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Gray
            ),
            modifier = Modifier.padding(top = 6.dp)
        )
    }
}

@Composable
private fun InfoContent() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "Inicia sesión en Quickness Dynamics",
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Sigue las instrucciones a continuación para iniciar sesión de forma segura:",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Gray
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = """
                        1. Abre la aplicación Quickness en tu teléfono.
                        2. Haz click en la camará.
                        3. Escanea el código QR que aparece en esta pantalla.
                    """.trimIndent(),
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.White,
                lineHeight = 24.sp
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        TextButton(
            onClick = { Uri().navigate("https://override.com.mx") },
            content = {
                Text(
                    text = "¿Necesitas ayuda para empezar?",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorScheme.primary
                    ),
                )
            }
        )
    }
}
