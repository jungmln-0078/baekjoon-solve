fun main() {
    val input = readln().split(" ")
    println(lcm13241(input[0].toLong(), input[1].toLong()))
}

fun gcd13241(a: Long, b: Long): Long {
    return if (b == 0.toLong()) a
    else gcd13241(b, a % b)
}

fun lcm13241(a: Long, b: Long): Long {
    return (a * b) / gcd13241(a, b)
}
