package jonisor.composenavigation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import jonisor.composenavigation.core.common.components.TextComponent
import jonisor.composenavigation.core.common.theme.AppTheme
import jonisor.composenavigation.feature.home.R
import jonisor.composenavigation.feature.home.ui.screen.destinations.HomeScreenDestination
import jonisor.composenavigation.feature.latest.ui.screen.destinations.LatestScreenDestination

@Composable
fun DrawerContent(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.paddingSmall)
    ) {
        Box(
            modifier = Modifier
                .height(104.dp)
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colors.primary,
                            MaterialTheme.colors.background,
                            MaterialTheme.colors.background
                        )
                    )
                )
                .padding(
                    horizontal = AppTheme.dimensions.paddingRegular,
                    vertical = AppTheme.dimensions.paddingLarge
                )
        ) {
            TextComponent(
                text = stringResource(id = R.string.MENU_TITLE),
                style = MaterialTheme.typography.h6
            )
        }
        Column(modifier = Modifier.padding(AppTheme.dimensions.paddingRegular)) {
            Row(
                modifier = Modifier.clickable { navController.navigate(HomeScreenDestination) },
                horizontalArrangement = Arrangement.spacedBy(AppTheme.dimensions.paddingExtraSmall)
            ) {
                Box(modifier = Modifier.size(48.dp)) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.rose
                        ),
                        contentDescription = "background",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.matchParentSize()
                    )
                }
                TextComponent(
                    text = stringResource(id = R.string.MENU_ITEM_HOME),
                    textDecoration = TextDecoration.Underline,
                    style = MaterialTheme.typography.h3
                )
            }
            Row(
                modifier = Modifier.clickable { navController.navigate(LatestScreenDestination) },
                horizontalArrangement = Arrangement.spacedBy(AppTheme.dimensions.paddingExtraSmall)
            ) {
                Box(modifier = Modifier.size(48.dp)) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.rose
                        ),
                        contentDescription = "background",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.matchParentSize()
                    )
                }
                TextComponent(
                    text = stringResource(id = R.string.MENU_ITEM_ADS_ARTIST),
                    textDecoration = TextDecoration.Underline,
                    style = MaterialTheme.typography.h3
                )
            }
            Row(
                modifier = Modifier.clickable { },
                horizontalArrangement = Arrangement.spacedBy(AppTheme.dimensions.paddingExtraSmall)
            ) {
                Box(modifier = Modifier.size(48.dp)) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.rose
                        ),
                        contentDescription = "background",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.matchParentSize()
                    )
                }
                TextComponent(
                    text = stringResource(id = R.string.MENU_ITEM_ADS_CLIENT),
                    textDecoration = TextDecoration.Underline,
                    style = MaterialTheme.typography.h3
                )
            }
            Spacer(modifier = Modifier.height(AppTheme.dimensions.paddingExtraLarge))
            Row(
                modifier = Modifier.clickable { },
                horizontalArrangement = Arrangement.spacedBy(AppTheme.dimensions.paddingExtraSmall)
            ) {
                Box(modifier = Modifier.size(48.dp)) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.rose
                        ),
                        contentDescription = "background",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.matchParentSize()
                    )
                }
                TextComponent(
                    text = stringResource(id = R.string.MENU_ITEM_PROFILE),
                    textDecoration = TextDecoration.Underline,
                    style = MaterialTheme.typography.h3
                )
            }
        }
    }
}