val numPad = mutableListOf(
    mutableListOf(7),
    mutableListOf(2, 4),
    mutableListOf(1, 3, 5),
    mutableListOf(2, 6),
    mutableListOf(1, 5, 7),
    mutableListOf(2, 4, 6, 8),
    mutableListOf(3, 5, 9),
    mutableListOf(0, 4, 8),
    mutableListOf(5, 7, 9),
    mutableListOf(6, 8)
)
val dp2780 = mutableMapOf(1 to 10)
val dpNumpad2780 = mutableMapOf<Pair<Int, Int>, Int>()

fun main() {
    val T = readln().toInt()
    for (i: Int in 1..T) {
        val N = readln().toInt()
        if (dp2780[N] != null) {
            println(dp2780[N]!! % 1234567)
            continue
        }
        dp2780[N] = 0
        for (numIdx: Int in numPad.indices) {
            dp2780[N] = dp2780[N]!! + d2780(numIdx, N)
        }
        println(dp2780[N]!! % 1234567)
    }
}

fun d2780(num: Int, size: Int): Int {
    if (dpNumpad2780[size to num] != null) return dpNumpad2780[size to num]!!
    return if (size == 2) {
        dpNumpad2780[size to num] = numPad[num].size
        dpNumpad2780[size to num]!! % 1234567
    } else {
        var n = 0
        for (i: Int in numPad[num]) {
            n += d2780(i, size - 1) % 1234567
        }
        dpNumpad2780[size to num] = n
        dpNumpad2780[size to num]!! % 1234567
    }
}
