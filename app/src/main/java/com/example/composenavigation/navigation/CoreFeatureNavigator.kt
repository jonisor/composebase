package com.example.composenavigation.navigation

import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import com.example.composenavigation.feature.home.ui.screen.HomeScreenNavigator
import com.example.composenavigation.feature.home.ui.screen.destinations.HomeScreenDestination
import com.example.composenavigation.feature.latest.ui.screen.LatestScreenNavigator
import com.example.composenavigation.feature.latest.ui.screen.destinations.LatestScreenDestination

class CoreFeatureNavigator(
    private val navController: NavController
): HomeScreenNavigator, LatestScreenNavigator {
    override fun navigateToLatest() {
        navController.navigate(LatestScreenDestination)
    }
    override fun navigateToHomeScreen() {
        navController.navigate(HomeScreenDestination)
    }
    override fun popBackStack() {
        navController.popBackStack()
    }
}