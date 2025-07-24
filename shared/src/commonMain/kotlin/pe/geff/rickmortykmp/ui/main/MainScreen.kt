package pe.geff.rickmortykmp.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import pe.geff.rickmortykmp.ui.core.navigation.bottomnavigation.BottomBarItem
import pe.geff.rickmortykmp.ui.core.navigation.bottomnavigation.NavigationBottomWrapper

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf(BottomBarItem.Characters(), BottomBarItem.Episodes())
    Scaffold(
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                NavigationBottomWrapper(navController)
            }
        },
        bottomBar = {
            BottomNavigation(items, navController)
        }
    )
}

@Composable
private fun BottomNavigation(items: List<BottomBarItem>, navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(containerColor = Color.Gray, contentColor = Color.Green) {
        items.forEach { item ->
            val isSelected = currentDestination?.hasRoute(item.route::class) == true
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Blue,
                    selectedIconColor = Color.Red,
                    unselectedIconColor = Color.Yellow
                ),
                icon = item.icon,
                label = {
                    Text(text = item.title, color = Color.White)
                },
                onClick = {
                    navController.navigate(route = item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                selected = isSelected,
                alwaysShowLabel = true
            )
        }
    }
}
