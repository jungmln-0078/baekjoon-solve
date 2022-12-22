fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val N = input[0]
    val K = input[1]

    println(factorial(N) / (factorial(N - K) * factorial(K)))
}

fun factorial(n: Int): Int {
    var result = 1
    (1..n).forEach { result *= it }
    return result
}
