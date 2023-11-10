package com.example.composenavigation.navigation

import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder

fun DependenciesContainerBuilder<*>.currentNavigator(): CoreFeatureNavigator {
    return CoreFeatureNavigator(navController = navController)
}