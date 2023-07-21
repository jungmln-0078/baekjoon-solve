fun main() {
    val (N, P, Q, X, Y) = readln().split(" ").map { it.toLong() }
    val dp = mutableMapOf<Long, Long>()
    dp[0] = 1
    fun d(n: Long): Long {
        if (dp[n] != null) return dp[n]!!
        if (n <= 0) {
            dp[n] = 1
        } else {
            dp[n] = d((n / P) - X) + d((n / Q) - Y)
        }
        return dp[n]!!
    }
    println(d(N))
}
