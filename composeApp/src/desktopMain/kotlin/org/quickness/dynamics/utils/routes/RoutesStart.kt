package org.quickness.dynamics.utils.routes

sealed class RoutesStart(val route: String) {
    data object Login : RoutesStart("login")
    data object Home : RoutesStart("home")
}