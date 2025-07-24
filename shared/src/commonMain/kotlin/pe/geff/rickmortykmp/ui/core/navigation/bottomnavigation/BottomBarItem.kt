package pe.geff.rickmortykmp.ui.core.navigation.bottomnavigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pe.geff.rickmortykmp.ui.core.navigation.CharactersScreen
import pe.geff.rickmortykmp.ui.core.navigation.EpisodesScreen

sealed class BottomBarItem {
    abstract val route: Any
    abstract val title: String
    abstract val icon: @Composable () -> Unit

    data class Episodes(
        override val route: Any = EpisodesScreen,
        override val title: String = "Episodes",
        override val icon: @Composable () -> Unit = {
            Icon(
                imageVector = Icons.Default.Movie,
                contentDescription = "Episodes",
                modifier = Modifier.size(24.dp)
            )
        }
    ) : BottomBarItem()

    data class Characters(
        override val route: Any = CharactersScreen,
        override val title: String = "Characters",
        override val icon: @Composable () -> Unit = {
            Icon(
                imageVector = Icons.Default.Group,
                contentDescription = "Characters",
                modifier = Modifier.size(24.dp)
            )
        }
    ) : BottomBarItem()
}
