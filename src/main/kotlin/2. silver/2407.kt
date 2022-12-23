import java.math.BigInteger

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val n = input[0]
    val m = input[1]
    println(factorial_(n) / (factorial_(n - m) * factorial_(m)))
}

fun factorial_(n: Int): BigInteger {
    var result = BigInteger.valueOf(1)
    (1..n).forEach { result *= it.toBigInteger() }
    return result
}
