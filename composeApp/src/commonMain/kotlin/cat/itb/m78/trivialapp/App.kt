package cat.itb.m78.trivialapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import cat.itb.m78.trivialapp.theme.AppTheme
import kotlinx.coroutines.launch
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.icon
import org.jetbrains.compose.resources.painterResource
import kotlin.random.Random

@Composable
internal fun App() = AppTheme {
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
