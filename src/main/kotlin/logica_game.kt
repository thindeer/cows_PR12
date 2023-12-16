// Класс, представляющий результат оценки догадки.
data class GuessResult(val bulls: Int, val cows: Int)

// Генерация тайного числа.
fun generateSecretNumber(): String {
    // Создание перемешанного списка цифр от '0' до '9'.
    val digits = ('0'..'9').shuffled()
    // Выбор первых четырех цифр и их объединение в строку.
    return digits.subList(0, 4).joinToString("")
}

// Оценка догадки по сравнению с тайным числом.
fun rateGuess(guess: String, secretNumber: String): GuessResult {
    // Переменные для хранения количества быков и коров.
    var bulls = 0
    var cows = 0

    for (i in guess.indices) {
        if (guess[i] == secretNumber[i]) {
            bulls++
        } else if (secretNumber.contains(guess[i])) {
            cows++
        }
    }

    return GuessResult(bulls, cows)
}