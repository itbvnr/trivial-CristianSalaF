package cat.itb.m78.trivialapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
internal fun App() {
    val navController = rememberNavController()
    val gameState = remember { GameState() }

    Box(modifier = Modifier.fillMaxSize()) {
        /*Image(
            painter = painterResource("background.png"),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )*/

        NavHost(navController, startDestination = "menu") {
            composable("menu") { MenuScreen(navController) }
            composable("game") { GameScreen(navController, gameState) }
            composable("result") { ResultScreen(navController, gameState) }
            composable("settings") { SettingsScreen(navController) }
        }
    }
}