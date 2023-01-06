fun main() {
    val input = readln().split(" ")
    val N = input[0].toInt()
    val K = input[1].toInt()
    val items = mutableListOf<Pair<Int, Int>>()
    for (i: Int in 1..N) {
        val thing = readln().split(" ").map { it.toInt() }
        items.add(thing[0] to thing[1])
    }
    val dp = MutableList(K + 1){ 0 }
    for (i: Int in 0 until N) {
        for (k: Int in K downTo 1) {
            if (items[i].first <= k) {
                if (dp[k] < dp[k - items[i].first] + items[i].second) {
                    dp[k] = dp[k - items[i].first] + items[i].second
                }
            }
        }
    }
    println(dp[K])
}
