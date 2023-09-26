import kotlin.math.min

fun main() {
    val N = readln().toInt()
    val dp = mutableMapOf(1 to 0, 2 to 1, 3 to 1)
    if (dp[N] != null) {
        println(dp[N])
        return
    }
    for (i: Int in 4..N) {
        if (i % 3 == 0 && i % 2 == 0) dp[i] = minOf(dp[i / 3]!! + 1, dp[i / 2]!! + 1, dp[i - 1]!! + 1)
        else if (i % 3 == 0) dp[i] = min(dp[i / 3]!! + 1, dp[i - 1]!! + 1)
        else if (i % 2 == 0) dp[i] = min(dp[i / 2]!! + 1, dp[i - 1]!! + 1)
        else dp[i] = dp[i - 1]!! + 1
    }
    println(dp[N])
}
