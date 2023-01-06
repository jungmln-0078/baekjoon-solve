val dp9095 = mutableMapOf<Int, Int>()
fun main() {
    val N = readln().toInt()
    dp9095[1] = 1
    dp9095[2] = 2
    dp9095[3] = 4
    for (i: Int in 1..N) {
        println(d9095(readln().toInt()))
    }
}

fun d9095(n: Int): Int {
    if (dp9095[n] != null) return dp9095[n]!!
    dp9095[n] = d9095(n - 3) + d9095(n - 2) + d9095(n - 1)
    return dp9095[n]!!
}
