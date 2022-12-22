import kotlin.math.absoluteValue
import kotlin.math.ceil

fun main() {
    val input = readln().split(" ")
    val x = input[0].toInt()
    val b = input[1].toInt()
    var tempX = x
    val tempResult = mutableListOf<String>()
    var result: String
    while (true) {
        val mod = tempX % b
        if (mod < 0 && b < 0) {
            tempResult.add((b.absoluteValue + mod).toString())
        } else if (mod < 0 && x < 0) {
            tempResult.add(mod.absoluteValue.toString())
        } else {
            tempResult.add(mod.toString())
        }
        tempX = if (b < 0) ceil(tempX.toDouble() / b.toDouble()).toInt() else tempX / b
        if (tempX == 0) {
            break
        }
    }
    result = tempResult.reversed().joinToString("")
    if (x < 0 && b > 0) {
        result = "-$result"
    }
    println(result)
}
