package dev.progrover.vktestcase.videoitem.api

import androidx.navigation.NavController

object VideoItemFeature {

    const val ROUTE_NAME = "videoListFeature"
    const val VIDEOITEM_SCREEN = "videoListScreenRoute"

    fun openVideoListScreen(navController: NavController, videoJson: String) =
        navController.navigate("$VIDEOITEM_SCREEN/$videoJson")
}
