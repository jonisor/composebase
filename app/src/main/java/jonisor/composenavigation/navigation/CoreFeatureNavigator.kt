package jonisor.composenavigation.navigation

import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import jonisor.composenavigation.feature.home.ui.screen.HomeScreenNavigator
import jonisor.composenavigation.feature.home.ui.screen.destinations.HomeScreenDestination
import jonisor.composenavigation.feature.latest.ui.screen.LatestScreenNavigator
import jonisor.composenavigation.feature.latest.ui.screen.destinations.LatestScreenDestination

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