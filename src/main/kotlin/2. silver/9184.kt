val memo9184 = mutableMapOf<Triple<Int, Int, Int>, Int>()
fun main() {
    while (true) {
        val input = readln().split(" ")
        val a = input[0].toInt()
        val b = input[1].toInt()
        val c = input[2].toInt()
        if (a == -1 && b == -1 && c == -1) break
        val w = w(a, b, c)
        println("w($a, $b, $c) = $w")
    }
}

fun w(a: Int, b: Int, c: Int): Int {
    if (memo9184[Triple(a, b, c)] != null) return memo9184[Triple(a, b, c)]!!
    if (a <= 0 || b <= 0 || c <= 0) {
        return 1
    }
    if (a > 20 || b > 20 || c > 20) {
        memo9184[Triple(a, b, c)] = w(20, 20, 20)
        return memo9184[Triple(a, b, c)]!!
    }
    if (a < b && b < c) {
        memo9184[Triple(a, b, c)] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)
        return memo9184[Triple(a, b, c)]!!
    }
    memo9184[Triple(a, b, c)] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b-1, c - 1)
    return memo9184[Triple(a, b, c)]!!
}
