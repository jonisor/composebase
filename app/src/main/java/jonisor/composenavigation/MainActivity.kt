package jonisor.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import jonisor.composenavigation.navigation.AppNavigation
import jonisor.composenavigation.core.common.theme.ComposeNavigationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            
            ComposeNavigationTheme {
                AppNavigation(
                    navController = navController
                )
            }
        }
    }
}