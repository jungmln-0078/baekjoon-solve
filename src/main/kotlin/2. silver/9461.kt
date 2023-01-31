val P9461 = MutableList<Long?>(101){ null }
fun main() {
    val T = readln().toInt()
    P9461[1] = 1
    P9461[2] = 1
    P9461[3] = 1
    for (i: Int in 1..T) {
        println(dp9461(readln().toInt()))
    }
}

fun dp9461(N: Int): Long {
    if (P9461[N] != null) return P9461[N]!!
    P9461[N] = dp9461(N - 2) + dp9461(N - 3)
    return P9461[N]!!
}
