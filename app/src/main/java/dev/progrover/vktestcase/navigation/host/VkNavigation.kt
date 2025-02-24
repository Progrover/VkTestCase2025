package dev.progrover.vktestcase.navigation.host

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import dev.progrover.vktestcase.base.navigation.NavigationFactory
import dev.progrover.vktestcase.videolist.api.VideoListFeature

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
internal fun VkNavigation(
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    navigationFactories: @JvmSuppressWildcards Set<NavigationFactory>,
) {

    Scaffold(
        scaffoldState = scaffoldState,
    ) {

        NavHost(navController = navController, startDestination = VideoListFeature.ROUTE_NAME) {
            navigationFactories.forEach { factory ->
                factory.create(this, navController = navController)
            }
        }
    }
}