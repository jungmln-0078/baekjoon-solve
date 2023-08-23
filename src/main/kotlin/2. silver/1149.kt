fun main() {
    val N = readln().toInt()
    val houses = mutableListOf<List<Int>>()
    for (i: Int in 1..N) {
        houses.add(readln().split(" ").map { it.toInt() })
    }
    val dp = mutableMapOf<Pair<Int, String>, Int>()
    dp[1 to "R"] = houses[0][0]
    dp[1 to "G"] = houses[0][1]
    dp[1 to "B"] = houses[0][2]
    for (i: Int in 2..N) {
        dp[i to "R"] = houses[i - 1][0] + minOf(dp[i - 1 to "G"]!!, dp[i - 1 to "B"]!!)
        dp[i to "G"] = houses[i - 1][1] + minOf(dp[i - 1 to "R"]!!, dp[i - 1 to "B"]!!)
        dp[i to "B"] = houses[i - 1][2] + minOf(dp[i - 1 to "R"]!!, dp[i - 1 to "G"]!!)
    }
    println(minOf(dp[N to "R"]!!, dp[N to "G"]!!, dp[N to "B"]!!))
}
