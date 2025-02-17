package cat.itb.m78.trivialapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class TrivialSettings(
    val difficulty: TrivialSubject = TrivialSubject.Kotlin,
    val questionsPerGame: Int = 10,
    val timePerRound: Int = 30
)

object TrivialSettingsManager {
    private var settings by mutableStateOf(TrivialSettings())

    fun update(newSettings: TrivialSettings) {
        if (settings != newSettings) {
            settings = newSettings.copy()
        }
    }

    fun get() = settings
}