package jonisor.composenavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DrawerValue
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import jonisor.composenavigation.navigation.AppNavigation
import jonisor.composenavigation.core.common.theme.ComposeNavigationTheme
import dagger.hilt.android.AndroidEntryPoint
import jonisor.composenavigation.core.common.components.TextComponent
import jonisor.composenavigation.core.common.theme.AppTheme
import jonisor.composenavigation.ui.component.DrawerContent
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(
            window,
            false
        )

        setContent {
            val navController = rememberNavController()
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            val scope = rememberCoroutineScope()
            
            ComposeNavigationTheme {
                ModalDrawer(
                    drawerState = drawerState,
                    drawerShape = RoundedCornerShape(AppTheme.dimensions.paddingRegular),
                    drawerContent = {
                        DrawerContent(navController = navController)
                    },
                    content = {
                        Scaffold(
                            floatingActionButton = {
                                ExtendedFloatingActionButton(
                                    onClick = {
                                    scope.launch {
                                        drawerState.open()
                                    }},
                                    shape = RoundedCornerShape(AppTheme.dimensions.paddingRegular),
                                    backgroundColor = MaterialTheme.colors.primary,
                                    text =  {
                                        TextComponent(
                                            text = "Menu",
                                            style = MaterialTheme.typography.h3
                                        )
                                    }
                                )
                            }
                        ) {
                            AppNavigation(
                                navController = navController
                            )
                        }
                    }
                )
            }
        }
    }
}