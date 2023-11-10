package com.example.composenavigation.navigation

import com.example.composenavigation.feature.home.ui.screen.destinations.HomeScreenDestination
import com.example.composenavigation.feature.latest.ui.screen.destinations.LatestScreenDestination
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec

object NavGraphs {

    val latest = object : NavGraphSpec {
        override val route: String = "profile"
        override val startRoute = LatestScreenDestination
        override val destinationsByRoute: Map<String, DestinationSpec<*>>
            get() = listOf<DestinationSpec<*>>(LatestScreenDestination)
                .associateBy { it.route }
    }

    val home = object : NavGraphSpec {
        override val route: String = "home"
        override val startRoute = HomeScreenDestination
        override val destinationsByRoute: Map<String, DestinationSpec<*>>
            get() = listOf<DestinationSpec<*>>(HomeScreenDestination)
                .associateBy { it.route }
    }

    val root = object : NavGraphSpec {
        override val route = "root"
        override val startRoute = home
        override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()
        override val nestedNavGraphs = listOf(home, latest)
    }

}