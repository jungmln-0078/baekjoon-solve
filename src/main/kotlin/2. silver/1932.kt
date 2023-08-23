fun main() {
    val n = readln().toInt()
    val triangle = mutableListOf<List<Int>>()
    val dp = mutableMapOf<Pair<Int, Int>, Int>() // <Pair<A, B>, C> A행의 B번째 값을 지날때 최대값 C
    for (i: Int in 1..n) {
        triangle.add(readln().split(" ").map { it.toInt() })
    }
    dp[0 to 0] = triangle[0][0]
    for (i: Int in 1 until n) {
        for (j: Int in 0..i) {
            if (j == 0) dp[i to j] = triangle[i][j] + dp[i - 1 to j]!!
            else if (j < i) dp[i to j] = triangle[i][j] + maxOf(dp[i - 1 to j - 1]!!, dp[i - 1 to j]!!)
            else dp[i to j] = triangle[i][j] + dp[i - 1 to j - 1]!!
        }
    }
    val lastValues = mutableListOf<Int>()
    for (i: Int in 0 until n) {
        lastValues.add(dp[n - 1 to i]!!)
    }
    println(lastValues.max())
}
