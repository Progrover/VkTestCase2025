package dev.progrover.vktestcase.videoitem.impl.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import dev.progrover.vktestcase.base.navigation.NavigationFactory
import dev.progrover.vktestcase.videoitem.api.VideoItemFeature.ROUTE_NAME
import dev.progrover.vktestcase.videoitem.api.VideoItemFeature.VIDEOITEM_SCREEN
import dev.progrover.vktestcase.videoitem.impl.presentation.screen.VideoItemScreen
import dev.progrover.vktestcase.videoitem.impl.presentation.viewmodel.VideoItemViewModel
import javax.inject.Inject

class VideoListNavigationFactory @Inject constructor() : NavigationFactory {

    override fun create(builder: NavGraphBuilder, navController: NavHostController) {
        builder.navigation(
            startDestination = VIDEOITEM_SCREEN,
            route = ROUTE_NAME
        ) {

            composable(
                route = ITEM_PAGE,
                arguments = listOf(
                    navArgument(ARG_VIDEO) { type = NavType.StringType },
                )
            ) {
                val viewModel: VideoItemViewModel = hiltViewModel()
                VideoItemScreen(viewModel = viewModel, navController = navController)
            }
        }
    }

    companion object {
        internal const val ARG_VIDEO = "argKey"
        private const val ITEM_PAGE = "$VIDEOITEM_SCREEN/{$ARG_VIDEO}"
    }
}