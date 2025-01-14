package org.quickness.dynamics.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import org.jetbrains.compose.resources.Font
import quicknessdynamics.composeapp.generated.resources.Raleway_Bold
import quicknessdynamics.composeapp.generated.resources.Raleway_Medium
import quicknessdynamics.composeapp.generated.resources.Raleway_Thin
import quicknessdynamics.composeapp.generated.resources.Res

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF1f1e1d),
    secondary = Color(0x1a1a1a96),
    background = Color(0xFF1f1e1d),
    tertiary = Color(0xFF20aef3)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFe3dcbb),
    secondary = Color(0xFF1f1e1d),
    background = Color(0xFFe3dcbb)
)

@Composable
fun Typography(): Typography {
    val ralewayBold = FontFamily(Font(Res.font.Raleway_Bold))
    val ralewayMedium = FontFamily(Font(Res.font.Raleway_Medium))
    val ralewayThin = FontFamily(Font(Res.font.Raleway_Thin))

    return Typography(
        titleLarge = TextStyle(fontFamily = ralewayBold),
        titleMedium = TextStyle(fontFamily = ralewayMedium),
        titleSmall = TextStyle(fontFamily = ralewayThin),
        bodyLarge = TextStyle(fontFamily = ralewayBold),
        bodyMedium = TextStyle(fontFamily = ralewayMedium),
        bodySmall = TextStyle(fontFamily = ralewayThin),
        labelLarge = TextStyle(fontFamily = ralewayBold),
        labelMedium = TextStyle(fontFamily = ralewayMedium),
        labelSmall = TextStyle(fontFamily = ralewayThin),
        displayLarge = TextStyle(fontFamily = ralewayBold),
        displayMedium = TextStyle(fontFamily = ralewayMedium),
        displaySmall = TextStyle(fontFamily = ralewayThin),
        headlineLarge = TextStyle(fontFamily = ralewayBold),
        headlineMedium = TextStyle(fontFamily = ralewayMedium),
        headlineSmall = TextStyle(fontFamily = ralewayThin)
    )
}

@Composable
fun QuicknessDynamicsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = org.quickness.dynamics.ui.theme.Typography(),
        content = content,
    )
}