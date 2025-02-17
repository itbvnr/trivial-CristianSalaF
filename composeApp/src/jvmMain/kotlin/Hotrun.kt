
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.awt.Dimension
import cat.itb.m78.trivialapp.App
import org.jetbrains.compose.reload.DevelopmentEntryPoint

fun main() = application {
    Window(
        title = "TrivialApp-cs7e8",/*
        state = rememberWindowState(width = 800.dp, height = 600.dp),*/
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(350, 600)
        DevelopmentEntryPoint {
            App()
        }
    }
}

