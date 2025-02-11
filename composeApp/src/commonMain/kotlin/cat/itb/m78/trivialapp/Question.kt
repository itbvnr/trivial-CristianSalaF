package cat.itb.m78.trivialapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.icon
import org.jetbrains.compose.resources.painterResource
import kotlin.time.measureTime

@Composable
fun PrintQuestion(time : Int, difficulty: TrivialSubject , questionsPerGame: Int) {
    /*var time by remember { measureTime { /*time  - current time*/ }}*/

    Box(Modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text("Round currRound / $questionsPerGame")

            Button(onClick = {
                //button code
            }){
                Text("New Game")
            }

            Button(onClick = {
                //button code
            }){
                Text("Settings")
            }
        }
    }
}