package dev.progrover.vktestcase.videoitem.impl.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.progrover.vktestcase.base.navigation.NavigationFactory
import dev.progrover.vktestcase.videoitem.impl.presentation.screen.VideoListScreen
import dev.progrover.vktestcase.videoitem.impl.presentation.viewmodel.VideoListViewModel
import dev.progrover.vktestcase.videolist.api.VideoListFeature.ROUTE_NAME
import dev.progrover.vktestcase.videolist.api.VideoListFeature.VIDEOLIST_SCREEN
import javax.inject.Inject

class VideoListNavigationFactory @Inject constructor() : NavigationFactory {

    override fun create(builder: NavGraphBuilder, navController: NavHostController) {
        builder.navigation(
            startDestination = VIDEOLIST_SCREEN,
            route = ROUTE_NAME
        ) {

            composable(route = VIDEOLIST_SCREEN) {
                val viewModel: VideoListViewModel = hiltViewModel()
                VideoListScreen(viewModel = viewModel, navController = navController)
            }
        }
    }
}