import kotlin.math.ceil
import kotlin.math.sqrt

fun main() {
    while(true) {
        val input = readln().toInt()
        var yaksu = mutableListOf<Int>()
        if (input == -1) break
        for (i: Int in 1..ceil(sqrt(input.toDouble())).toInt()) {
            if (input % i == 0) yaksu.add(i)
            if (i != input / i && input % i == 0) yaksu.add(input / i)
        }
        yaksu = yaksu.distinct().toMutableList()
        yaksu.sort()
        yaksu.removeAt(yaksu.lastIndex)
        if (input == yaksu.sum()) println("$input = ${yaksu.joinToString(" + ")}")
        else println("$input is NOT perfect.")
    }
}
