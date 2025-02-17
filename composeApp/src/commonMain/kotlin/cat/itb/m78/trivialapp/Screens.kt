package cat.itb.m78.trivialapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import m78exercices.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
fun MenuScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        /*Image(
            painter = painterResource(Res.drawable.icon),
            contentDescription = "Game Icon",
            modifier = Modifier.size(120.dp)
        )*/
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Trivial - CSala7e8",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                navController.navigate("game") {
                    popUpTo("menu") { inclusive = true }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.9f)
            )
        ) {
            Text("Partida nova")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("settings") },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.9f)
            )
        ) {
            Text("Configuració")
        }
    }
}

@Composable
fun GameScreen(navController: NavController, gameState: GameState) {
    val currentQuestion = gameState.currentQuestion
    val timePerRound = TrivialSettingsManager.get().timePerRound

    LaunchedEffect(gameState.isGameOver) {
        if (gameState.isGameOver) {
            navController.navigate("result")
        }
    }

    if (currentQuestion == null) {
        return
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Ronda ${gameState.currentRound}/${gameState.totalRounds}",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Puntuació: ${gameState.score}",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            currentQuestion.question,
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(32.dp))

        currentQuestion.answers.forEachIndexed { index, answer ->
            Button(
                onClick = { gameState.checkAnswer(index) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(answer)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Temps: ${gameState.remainingTime}s",
            style = MaterialTheme.typography.titleLarge,
            color = if (gameState.remainingTime <= 5) Color.Red else Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        Slider(
            value = gameState.remainingTime.toFloat(),
            onValueChange = { /* Not used, slider is read-only */ },
            valueRange = 0f..timePerRound.toFloat(),
            enabled = false,
            colors = SliderDefaults.colors(
                thumbColor = if (gameState.remainingTime <= 5) Color.Red else MaterialTheme.colorScheme.primary,
                activeTrackColor = if (gameState.remainingTime <= 5) Color.Red else MaterialTheme.colorScheme.primary,
                disabledThumbColor = if (gameState.remainingTime <= 5) Color.Red else MaterialTheme.colorScheme.primary,
                disabledActiveTrackColor = if (gameState.remainingTime <= 5) Color.Red else MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.width(200.dp)
        )
    }
}

@Composable
fun ResultScreen(navController: NavController, gameState: GameState) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Game Over!",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "La teva puntuació: ${gameState.score}/${gameState.totalRounds}",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            gameState.resetGame()
            navController.navigate("menu")
        }) {
            Text("Tornar al menú")
        }
    }
}

@Composable
fun SettingsScreen(navController: NavController) {
    var difficulty by remember { mutableStateOf(TrivialSettingsManager.get().difficulty) }
    var rounds by remember { mutableStateOf(TrivialSettingsManager.get().questionsPerGame) }
    var timePerRound by remember { mutableStateOf(TrivialSettingsManager.get().timePerRound) }
    var isDropdownExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Tema", style = MaterialTheme.typography.titleLarge)

        Box {
            Button(onClick = { isDropdownExpanded = true }) {
                Text(difficulty.name)
            }

            DropdownMenu(
                expanded = isDropdownExpanded,
                onDismissRequest = { isDropdownExpanded = false }
            ) {
                TrivialSubject.values().forEach { subject ->
                    DropdownMenuItem(
                        onClick = {
                            difficulty = subject
                            isDropdownExpanded = false
                        },
                        text = { Text(subject.name) }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Nombre de preguntes", style = MaterialTheme.typography.titleLarge)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            listOf(5, 10, 15).forEach { number ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    RadioButton(
                        selected = rounds == number,
                        onClick = { rounds = number }
                    )

                    Text(number.toString())
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "Temps per pregunta: $timePerRound segons",
            style = MaterialTheme.typography.titleLarge
        )

        Slider(
            value = timePerRound.toFloat(),
            onValueChange = { timePerRound = it.toInt() },
            valueRange = 10f..60f
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                TrivialSettingsManager.update(
                    TrivialSettings(difficulty, rounds, timePerRound)
                )

                navController.navigate("menu")
            }
        ) {
            Text("Guardar i tornar")
        }
    }
}