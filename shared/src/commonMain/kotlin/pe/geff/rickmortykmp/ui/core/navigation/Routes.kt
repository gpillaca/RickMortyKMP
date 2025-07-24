package pe.geff.rickmortykmp.ui.core.navigation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Main")
data object MainScreen


@Serializable
@SerialName("Episodes")
data object EpisodesScreen

@Serializable
@SerialName("Characters")
data object CharactersScreen
