package dev.progrover.vktestcase.videolist.api

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

object VideoListFeature {

    const val ROUTE_NAME = "videoListFeature"
    const val VIDEOLIST_SCREEN = "videoListScreenRoute"

    fun openVideoListScreen(navController: NavController) =
        navController.navigate(VIDEOLIST_SCREEN) {
            popUpTo(navController.graph.findStartDestination().id) {
                inclusive = true
            }
        }
}
