package org.quickness.dynamics.ui.screens.home

import androidx.compose.animation.core.animateDpAsState
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
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.quickness.dynamics.ui.components.BackgroundAnimated
import org.quickness.dynamics.ui.components.TextFieldCustom
import org.quickness.dynamics.ui.navigation.NavigationHome
import quicknessdynamics.composeapp.generated.resources.Res
import quicknessdynamics.composeapp.generated.resources.search_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24

@Composable
fun HomeScreen() = Screen()

@Composable
private fun Screen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val navController = rememberNavController()
    val state by remember { viewModel.state }.collectAsState()
    Scaffold(
        floatingActionButton = { FloatingAction(state, viewModel) },
        content = { NavigationHome(navController) },
        topBar = { TopBar(state, viewModel) },
        bottomBar = { BottomBar(navController, state, viewModel) },
        containerColor = Color.Transparent,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = BackgroundAnimated(
                    colorBackground = colorScheme.background,
                    colorAnimated = colorScheme.primaryContainer
                )
            )
    )
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    state: HomeState,
    viewModel: HomeViewModel
) {
    val hover = remember { MutableInteractionSource() }
    val isHovered by hover.collectIsHoveredAsState()
    val width by animateDpAsState(
        targetValue = if (isHovered) 300.dp else 70.dp,
        animationSpec = tween(durationMillis = 300)
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
                state.icons.forEachIndexed { index, icons ->
                    ButtonBottomBar(
                        icon = icons.icon,
                        selected = index == state.selectedIndex,
                        onClick = {
                            viewModel.update { copy(selectedIndex = index) }
                            navController.navigate(icons.route)
                        }
                    )
                }
            } else {
                state.icons.indexOf(state.icons[state.selectedIndex]).let {
                    ButtonBottomBar(
                        icon = state.icons[it].icon,
                        selected = true,
                        onClick = {
                            viewModel.update { copy(selectedIndex = it) }
                            navController.navigate(state.icons[it].route)
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
private fun TopBar(
    state: HomeState,
    viewModel: HomeViewModel
) {
    val hover = remember { MutableInteractionSource() }
    val isHovered by hover.collectIsHoveredAsState()
    val width by animateDpAsState(
        targetValue = if (isHovered) if (state.isSearching) 70.dp else 400.dp else 70.dp,
        animationSpec = tween(durationMillis = 300)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(state.paddingValues),
        contentAlignment = state.alignment,
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
                if (state.isSearching) {
                    CircularProgressIndicator(modifier = Modifier.size(50.dp))
                    LaunchedEffect(Unit) {
                        if (state.isSearching) {
                            viewModel.update {
                                copy(
                                    paddingValues = 0.dp,
                                    alignment = Alignment.Center
                                )
                            }
                            delay(2000)
                            viewModel.update {
                                copy(
                                    isSearching = false,
                                    paddingValues = 16.dp,
                                    alignment = Alignment.TopCenter
                                )
                            }
                        }
                    }
                } else if (isHovered) {
                    Icon(
                        painter = painterResource(Res.drawable.search_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable { viewModel.update { copy(isSearching = !isSearching) } }
                            .size(50.dp),
                        tint = colorScheme.tertiary
                    )
                    TextFieldCustom(
                        value = state.searchText,
                        onValueChange = { viewModel.update { copy(searchText = it) } },
                        onDone = { viewModel.update { copy(isSearching = !isSearching) } },
                        onGo = { viewModel.update { copy(isSearching = !isSearching) } },
                        onSearch = { viewModel.update { copy(isSearching = !isSearching) } },
                        onSend = { viewModel.update { copy(isSearching = !isSearching) } },
                        keyboardType = KeyboardType.Text,
                        placeholder = "Search",
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
private fun FloatingAction(
    state: HomeState,
    viewModel: HomeViewModel
) {
    val hover = remember { MutableInteractionSource() }
    val isHovered by hover.collectIsHoveredAsState()
    val size by animateDpAsState(
        targetValue = if (isHovered) 200.dp else 70.dp,
        animationSpec = tween(durationMillis = 300)
    )

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
                        state.iconsList.forEachIndexed { index, drawableResource ->
                            Icon(
                                painter = painterResource(drawableResource),
                                tint = colorScheme.tertiary,
                                modifier = Modifier
                                    .clickable { viewModel.update { copy(indexSelected = index) } }
                                    .size(40.dp),
                                contentDescription = null,
                            )
                        }
                    } else {
                        Icon(
                            tint = colorScheme.tertiary,
                            modifier = Modifier.size(40.dp),
                            contentDescription = null,
                            painter = painterResource(
                                state.iconsList[
                                    state.iconsList.indexOf(
                                        state.iconsList[
                                            state.indexSelected
                                        ]
                                    )
                                ]
                            )
                        )
                    }
                }
            )
        }
    )
}
