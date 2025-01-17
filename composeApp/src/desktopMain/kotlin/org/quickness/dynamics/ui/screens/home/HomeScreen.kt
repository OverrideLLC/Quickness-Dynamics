package org.quickness.dynamics.ui.screens.home

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.quickness.dynamics.ui.navigation.NavigationHome
import org.quickness.dynamics.utils.routes.RoutesHome
import quicknessdynamics.composeapp.generated.resources.Res
import quicknessdynamics.composeapp.generated.resources.add_business_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import quicknessdynamics.composeapp.generated.resources.chat_bubble_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import quicknessdynamics.composeapp.generated.resources.dark_mode_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import quicknessdynamics.composeapp.generated.resources.dashboard_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import quicknessdynamics.composeapp.generated.resources.edit_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import quicknessdynamics.composeapp.generated.resources.person_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import quicknessdynamics.composeapp.generated.resources.search_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import quicknessdynamics.composeapp.generated.resources.settings_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import quicknessdynamics.composeapp.generated.resources.widgets_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24

@Composable
fun HomeScreen() = Screen()

@Composable
private fun Screen() {
    val navController = rememberNavController()
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
        floatingActionButton = { FloatingAction() },
        content = { Content(navController) },
        topBar = { TopBar() },
        bottomBar = { BottomBar(navController) },
        snackbarHost = { SnackBar() },
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    listOf(color2, color1, color1)
                )
            )
            .fillMaxSize(),
        containerColor = Color.Transparent
    )
}

@Composable
private fun Content(navController: NavHostController) {
    NavigationHome(navController)
}

@Composable
private fun BottomBar(navController: NavHostController) {
    val hover = remember { MutableInteractionSource() }
    val isHovered by hover.collectIsHoveredAsState()
    var selectedIndex by remember { mutableStateOf(2) }
    val width by animateDpAsState(
        targetValue = if (isHovered) 300.dp else 70.dp,
        animationSpec = tween(durationMillis = 300)
    )
    val icons = listOf(
        Pair(
            RoutesHome.Settings.route,
            Res.drawable.settings_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
        ),
        Pair(RoutesHome.Ai.route, Res.drawable.chat_bubble_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24),
        Pair(
            RoutesHome.Dashboard.route,
            Res.drawable.dashboard_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
        ),
        Pair(RoutesHome.Profile.route, Res.drawable.person_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24),
        Pair(
            RoutesHome.AddBusiness.route,
            Res.drawable.add_business_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
        )
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .width(width)
                .background(
                    color = colorScheme.primaryContainer.copy(alpha = 0.7f),
                    shape = RoundedCornerShape(32.dp)
                )
                .padding(16.dp)
                .hoverable(
                    interactionSource = hover,
                    enabled = true
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (isHovered) {
                icons.forEachIndexed { index, pair ->
                    ButtonBottomBar(
                        icon = pair.second,
                        selected = index == selectedIndex,
                        onClick = {
                            selectedIndex = index
                            navController.navigate(pair.first)
                        }
                    )
                }
            } else {
                icons.indexOf(icons[selectedIndex]).let {
                    ButtonBottomBar(
                        icon = icons[it].second,
                        selected = true,
                        onClick = {
                            selectedIndex = it
                            navController.navigate(icons[it].first)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun ButtonBottomBar(
    icon: DrawableResource,
    selected: Boolean,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val size by animateDpAsState(
        targetValue = if (isHovered) 50.dp else 40.dp,
        animationSpec = tween(durationMillis = 300)
    )

    Box(
        modifier = Modifier
            .size(size)
            .hoverable(interactionSource = interactionSource)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = if (selected) colorScheme.primary else colorScheme.tertiary
        )
    }
}

@Composable
private fun TopBar() {
    val hover = remember { MutableInteractionSource() }
    val isHovered by hover.collectIsHoveredAsState()
    var isSearching by remember { mutableStateOf(false) }
    val width by animateDpAsState(
        targetValue = if (isHovered) if (isSearching) 70.dp else 500.dp else 70.dp,
        animationSpec = tween(durationMillis = 300)
    )
    var searchText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(if (isSearching) 0.dp else 16.dp),
        contentAlignment = if (isSearching) Alignment.Center else Alignment.TopCenter,
        content = {
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .width(width)
                    .hoverable(
                        interactionSource = hover,
                        enabled = true
                    )
                    .background(
                        color = colorScheme.primaryContainer.copy(alpha = 0.7f),
                        shape = RoundedCornerShape(32.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                if (isSearching) {
                    CircularProgressIndicator(modifier = Modifier.size(50.dp))
                    LaunchedEffect(Unit) {
                        if (isSearching) {
                            delay(2000)
                            isSearching = !isSearching
                        }
                    }
                } else if (isHovered) {
                    Icon(
                        painter = painterResource(Res.drawable.search_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable { isSearching = !isSearching }
                            .size(50.dp),
                        tint = colorScheme.tertiary
                    )
                    OutlinedTextField(
                        value = searchText,
                        onValueChange = { searchText = it },
                        placeholder = { Text("Search...") },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = colorScheme.primary,
                            unfocusedIndicatorColor = colorScheme.tertiary,
                            cursorColor = colorScheme.tertiary,
                            focusedTextColor = colorScheme.primary,
                            unfocusedTextColor = colorScheme.tertiary,
                            focusedPlaceholderColor = colorScheme.primary,
                            unfocusedPlaceholderColor = colorScheme.tertiary,
                        ),
                        shape = RoundedCornerShape(32.dp),
                        singleLine = true,
                        maxLines = 1,
                        modifier = Modifier.size(300.dp, 50.dp)
                    )
                } else {
                    Icon(
                        painter = painterResource(Res.drawable.search_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp),
                        tint = colorScheme.tertiary
                    )
                }
            }
        }
    )
}

@Composable
private fun FloatingAction() {
    val hover = remember { MutableInteractionSource() }
    val isHovered by hover.collectIsHoveredAsState()
    val size by animateDpAsState(
        targetValue = if (isHovered) 200.dp else 70.dp,
        animationSpec = tween(durationMillis = 300)
    )
    val iconsList = listOf(
        Res.drawable.edit_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24,
        Res.drawable.widgets_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24,
        Res.drawable.dark_mode_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
    )
    var indexSelected by remember { mutableStateOf(1) }

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
            .offset(
                x = 0.dp,
                y = 100.dp
            ),
        contentAlignment = Alignment.CenterEnd,
        content = {
            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .height(size)
                    .background(
                        color = colorScheme.primaryContainer.copy(alpha = 0.7f),
                        shape = RoundedCornerShape(32.dp)
                    )
                    .padding(16.dp)
                    .hoverable(
                        interactionSource = hover,
                        enabled = true
                    ),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    if (isHovered) {
                        iconsList.forEachIndexed { index, drawableResource ->
                            Icon(
                                painter = painterResource(drawableResource),
                                tint = colorScheme.tertiary,
                                modifier = Modifier
                                    .clickable { indexSelected = index }
                                    .size(40.dp),
                                contentDescription = null,
                            )
                        }
                    } else {
                        iconsList.indexOf(iconsList[indexSelected]).let {
                            Icon(
                                painter = painterResource(iconsList[it]),
                                tint = colorScheme.tertiary,
                                modifier = Modifier
                                    .clickable { }
                                    .size(40.dp),
                                contentDescription = null,
                            )
                        }
                    }
                }
            )
        }
    )
}

@Composable
private fun SnackBar() {
}