package org.quickness.dynamics.ui.states

import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.quickness.dynamics.ui.screens.home.HomeViewModel.IconsBottomBar
import org.quickness.dynamics.utils.routes.RoutesHome
import quicknessdynamics.composeapp.generated.resources.Res
import quicknessdynamics.composeapp.generated.resources.add_business_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import quicknessdynamics.composeapp.generated.resources.chat_bubble_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import quicknessdynamics.composeapp.generated.resources.dark_mode_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import quicknessdynamics.composeapp.generated.resources.dashboard_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import quicknessdynamics.composeapp.generated.resources.edit_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import quicknessdynamics.composeapp.generated.resources.person_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import quicknessdynamics.composeapp.generated.resources.settings_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import quicknessdynamics.composeapp.generated.resources.widgets_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24

data class HomeState(
    var selectedTab: Int = 2,
    var previousSelectedTab: Int = 1,
    var isSearchBarActive: Boolean = false,
    var contentPadding: Dp = 16.dp,
    var layoutAlignment: Alignment = Alignment.TopCenter,
    var searchBarInput: String = "",
    var drawableIcons: List<DrawableResource> = listOf(
        Res.drawable.edit_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24,
        Res.drawable.widgets_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24,
        Res.drawable.dark_mode_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
    ),
    val bottomBarIcons: List<IconsBottomBar> = listOf(
        IconsBottomBar(
            RoutesHome.Settings.route,
            Res.drawable.settings_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
        ),
        IconsBottomBar(
            RoutesHome.Ai.route,
            Res.drawable.chat_bubble_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
        ),
        IconsBottomBar(
            RoutesHome.Dashboard.route,
            Res.drawable.dashboard_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
        ),
        IconsBottomBar(
            RoutesHome.Profile.route,
            Res.drawable.person_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
        ),
        IconsBottomBar(
            RoutesHome.AddBusiness.route,
            Res.drawable.add_business_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
        )
    ),
)
