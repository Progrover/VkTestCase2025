package dev.platovco.core.base.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

/**
 * интерфейс для связывания всех вложенных графов навигации
 */
interface NavigationFactory {

    fun create(builder: NavGraphBuilder, navController: NavHostController)

}
const val NAV_ARG_HOTEL = "hotel"
const val NAV_ARG_RESTAURANT = "restaurant"