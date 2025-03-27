package org.quickness.dynamics.ui.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.quickness.dynamics.ui.screens.home.ai.AiScreen
import org.quickness.dynamics.ui.screens.home.dashboard.DashboardScreen
import org.quickness.dynamics.ui.screens.home.profile.ProfileScreen
import org.quickness.dynamics.ui.screens.home.settings.SettingsScreen
import org.quickness.dynamics.utils.routes.RoutesHome

@Composable
fun NavigationHome(navHost: NavHostController) {
    NavHost(
        navController = navHost,
        startDestination = RoutesHome.Dashboard.route,
        enterTransition = {
            slideInHorizontally(initialOffsetX = { -it })
        },
        exitTransition = {
            slideOutHorizontally(targetOffsetX = { -it })
        },
    ) {
        composable(RoutesHome.Dashboard.route) { DashboardScreen() }
        composable(RoutesHome.Ai.route) { AiScreen() }
        composable(RoutesHome.Settings.route) { SettingsScreen() }
        composable(RoutesHome.Profile.route) { ProfileScreen() }
        composable(RoutesHome.AddBusiness.route) {
            Box(
                contentAlignment = androidx.compose.ui.Alignment.Center,
                modifier = Modifier.fillMaxSize(),
            ) {
                Text(
                    text = "Add Business",
                    color = colorScheme.tertiary,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
        }
    }
}