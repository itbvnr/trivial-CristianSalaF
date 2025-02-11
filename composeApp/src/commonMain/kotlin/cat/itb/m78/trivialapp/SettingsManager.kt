package cat.itb.m78.trivialapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

enum class TrivialSubject{Kotlin, Html}
data class TrivialSettings(
    val difficulty : TrivialSubject = TrivialSubject.Kotlin,
    val questionsPerGame: Int = 10
)

data object TrivialSettingsManager{
    private var settings = TrivialSettings()
    fun update(newSettings: TrivialSettings){
        settings = newSettings
    }
    fun get() = settings
}