package jonisor.composenavigation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency

@Composable
internal fun AppNavigation(
    navController: NavHostController,
) {
    DestinationsNavHost(
        navController = navController,
        navGraph = NavGraphs.root,
        modifier = Modifier.fillMaxSize(),
        dependenciesContainerBuilder = {
            dependency(currentNavigator())
        }
    )
}