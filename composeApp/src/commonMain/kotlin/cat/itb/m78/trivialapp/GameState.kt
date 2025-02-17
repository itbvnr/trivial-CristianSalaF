package cat.itb.m78.trivialapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.*

class GameState {
    var currentRound by mutableStateOf(1)
    var score by mutableStateOf(0)
    var questions by mutableStateOf<List<Question>>(emptyList())
    var currentQuestion by mutableStateOf<Question?>(null)
    var isGameOver by mutableStateOf(false)
    var remainingTime by mutableStateOf(0)

    private var timerJob: Job? = null
    private var currentSettings by mutableStateOf(TrivialSettingsManager.get())

    val totalRounds get() = currentSettings.questionsPerGame

    init {
        CoroutineScope(Dispatchers.Main).launch {
            snapshotFlow { TrivialSettingsManager.get() }
                .collect { settings ->
                    currentSettings = settings
                    if (!isGameOver) {
                        startNewGame()
                    }
                }
        }

        startNewGame()
    }

    fun startNewGame() {
        questions = QuestionRepository.getRandomQuestions(
            currentSettings.difficulty,
            currentSettings.questionsPerGame
        )
        currentRound = 1
        score = 0
        isGameOver = false
        updateCurrentQuestion()
        startTimer()
    }

    private fun updateCurrentQuestion() {
        currentQuestion = if (currentRound <= questions.size) {
            questions[currentRound - 1]
        } else {
            null
        }

        if (currentQuestion != null) {
            startTimer()
        }
    }

    private fun startTimer() {
        timerJob?.cancel()
        remainingTime = currentSettings.timePerRound

        timerJob = CoroutineScope(Dispatchers.Main).launch {
            while (remainingTime > 0 && !isGameOver) {
                delay(1000)
                remainingTime--
                if (remainingTime == 0) {
                    nextRound()
                }
            }
        }
    }

    fun checkAnswer(answerIndex: Int) {
        if (isGameOver) return

        currentQuestion?.let { question ->
            if (answerIndex == question.correctAnswerIndex) {
                score++
            }
        }
        nextRound()
    }

    fun nextRound() {
        if (currentRound >= totalRounds) {
            isGameOver = true
            timerJob?.cancel()
        } else {
            currentRound++
            updateCurrentQuestion()
        }
    }

    fun resetGame() {
        timerJob?.cancel()
        startNewGame()
    }
}