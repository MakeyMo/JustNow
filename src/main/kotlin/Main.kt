fun main() {

    val secondsAgo: Int = (0..270_000).random()
    val minutesAgo: Int = secondsAgo / 60
    val hoursAgo: Int = minutesAgo / 60

    fun endingForSeconds(secondsAgo: Int): String {
        if (secondsAgo <= 10) {
            val lastChar = secondsAgo.toString().takeLast(1).toInt()
            when (lastChar) {
                in 5..9 -> return "секунд"
                1 -> return "секунда"
                in 2..4 -> return "секунды"
            }
        }
        else if (secondsAgo in 10..60) {
            val lastChar = secondsAgo.toString().takeLast(1).toInt()
            val twoLastChars = secondsAgo.toString().takeLast(2).toInt()
            when {
                twoLastChars == 0 || twoLastChars in 11..20 -> return "секунд"
                lastChar == 0 || lastChar in 5..9 -> return "секунд"
                lastChar == 1 -> return "секунда"
                lastChar in 2..4 -> return "секунды"
            }
        }
        return "облом"
    }

    fun endingForMinutes(minutesAgo: Int): String {
        if (minutesAgo <= 10) {
            val lastChar = minutesAgo.toString().takeLast(1).toInt()
            when (lastChar) {
                in 5..9 -> return "минут"
                1 -> return "минута"
                in 2..4 -> return "минуты"
            }
        }
        else if (minutesAgo in 10..60) {
            val lastChar = minutesAgo.toString().takeLast(1).toInt()
            val twoLastChars = minutesAgo.toString().takeLast(2).toInt()
            when {
                twoLastChars == 0 || twoLastChars in 11..20 -> return "минут"
                lastChar == 0 || lastChar in 5..9 -> return "минут"
                lastChar == 1 -> return "минута"
                lastChar in 2..4 -> return "минуты"
            }
        }
        return "облом"
    }

    fun endingForHours(hoursAgo: Int): String {
        if (hoursAgo <= 10) {
            val lastChar = hoursAgo.toString().takeLast(1).toInt()
            when (lastChar) {
                in 5..9 -> return "часов"
                1 -> return "час"
                in 2..4 -> return "часа"
            }
        }
        else if (hoursAgo in 10..24) {
            val lastChar = hoursAgo.toString().takeLast(1).toInt()
            val twoLastChars = hoursAgo.toString().takeLast(2).toInt()
            when {
                twoLastChars == 0 || twoLastChars in 11..20 -> return "часов"
                lastChar == 0 || lastChar in 5..9 -> return "часов"
                lastChar == 1 -> return "час"
                lastChar in 2..4 -> return "часа"
            }
        }
        return "облом"
    }

    fun agoToText(secondsAgo: Int): String {
        return when {
            secondsAgo == 0 -> return "Пользователь онлайн"
            secondsAgo in 1..60 -> return "Пользователь был в сети $secondsAgo ${endingForSeconds(secondsAgo)} назад"
            secondsAgo in 61..60 * 60 -> return "Пользователь был в сети " +
                    "$minutesAgo ${endingForMinutes(minutesAgo)} назад"
            secondsAgo in 60 * 60 + 1..24 * 60 * 60 -> return "Пользователь был в сети " +
                    "$hoursAgo ${endingForHours(hoursAgo)} назад"
            secondsAgo in 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> return "Пользователь был в сети сегодня"
            secondsAgo in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> return "Пользователь был в сети вчера"
            secondsAgo > 3 * 24 * 60 * 60 -> return "Пользователь был в сети давно"
            else -> "Пользователь был в сети давно"
        }
    }
    println(agoToText(secondsAgo))
}