fun main() {
    readln()
    val input = readln().split(" ").map { it.toInt() }
    for (i: Int in 1..input.lastIndex) {
        val gcd = gcd3036(input[0], input[i])
        println("${input[0] / gcd}/${input[i] / gcd}")
    }
}

fun gcd3036(a: Int, b: Int): Int {
    return if (b == 0) a
    else gcd3036(b, a % b)
}
