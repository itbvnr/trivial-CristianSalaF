package cat.itb.m78.trivialapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.trivialapp.theme.AppTheme
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.icon
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun App() = AppTheme {
    val viewModel = viewModel { TrivialViewModel() }

    Box(Modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(Res.drawable.icon),
                modifier = Modifier.size(128.dp).padding(10.dp),
                contentDescription = null)

            Button(onClick = {
                //button code
                viewModel.drawQuestion()
            }){
                Text("New Game")
            }

            Button(onClick = {
                //button code
            }){
                Text("Settings")
            }

            //slider, progressbar
            //check round time
        }
    }
}

class TrivialViewModel : ViewModel() {
    val text = mutableStateOf("Hello World")
    val difficuly : Int = 0;
    val score : Int = 0;
    val maxRounds : Int = 0;
    val currentRound by remember { mutableStateOf(0) }

    fun setDifficulty(difficulty: Int) {

    }

    fun setMaxRounds(){

    }

    fun setMaxRoundTime(){

    }

    @Composable
    fun drawQuestion(){

    }
}