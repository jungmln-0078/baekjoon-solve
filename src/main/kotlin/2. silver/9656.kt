fun main() {
    val N = readln().toInt()
    val dp = mutableMapOf(1 to false, 2 to true, 3 to false) // N 일때 상근이가 이기는지
    for (i: Int in 1..N) {
        if (dp[i] == null) {
            dp[i] = !dp[i - 3]!! || !dp[i - 1]!!
        }
        if (i == N) {
            println(if (dp[i]!!) "SK" else "CY")
            break
        }
    }
}