package cat.itb.m78.trivialapp


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cat.itb.m78.trivialapp.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    Box(Modifier.fillMaxSize()){
        Text("Your app goes here!", Modifier.align(Alignment.Center))
    }
}
