package pe.geff.rickmortykmp.ui.core.navigation.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import pe.geff.rickmortykmp.ui.characters.CharactersScreen
import pe.geff.rickmortykmp.ui.core.navigation.CharactersScreen
import pe.geff.rickmortykmp.ui.core.navigation.EpisodesScreen
import pe.geff.rickmortykmp.ui.episodes.EpisodesScreen

@Composable
fun NavigationBottomWrapper(navController: NavHostController) {
    NavHost(navController = navController, startDestination = CharactersScreen) {
        composable<CharactersScreen> {
            CharactersScreen()
        }

        composable<EpisodesScreen> {
            EpisodesScreen()
        }
    }
}
