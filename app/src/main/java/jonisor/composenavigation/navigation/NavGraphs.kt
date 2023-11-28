package jonisor.composenavigation.navigation

import jonisor.composenavigation.feature.home.ui.screen.destinations.HomeScreenDestination
import jonisor.composenavigation.feature.latest.ui.screen.destinations.LatestScreenDestination
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import jonisor.composenavigation.feature.latest.ui.screen.destinations.ArtistAdScreenDestination

object NavGraphs {

    val home = object : NavGraphSpec {
        override val route: String = "home"
        override val startRoute = HomeScreenDestination
        override val destinationsByRoute: Map<String, DestinationSpec<*>>
            get() = listOf<DestinationSpec<*>>(HomeScreenDestination)
                .associateBy { it.route }
    }

    val latest = object : NavGraphSpec {
        override val route: String = "latest"
        override val startRoute = LatestScreenDestination
        override val destinationsByRoute: Map<String, DestinationSpec<*>>
            get() = listOf<DestinationSpec<*>>(
                LatestScreenDestination,
                ArtistAdScreenDestination
            )
                .associateBy { it.route }
    }

    val root = object : NavGraphSpec {
        override val route = "root"
        override val startRoute = home
        override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()
        override val nestedNavGraphs = listOf(home, latest)
    }

}