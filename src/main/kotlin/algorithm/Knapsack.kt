package algorithm

/* 배낭 문제 (Knapsack 냅색 알고리즘)
    https://chanhuiseok.github.io/posts/improve-6/
    물건의 수를 N, 배낭의 최대 용량을 K라고 할때,
    무게(W)와 가치(V)를 가진 물건들을 가치가 최대가 되도록 배낭에 넣는 방법을 구하는 알고리즘
    냅색 알고리즘은 2차원 dp, 1차원 dp로 풀 수 있다.
    길이 K + 1의 1차원 배열 dp를 정의한다.
    dp[k]는 배낭의 용량이 k일때 최대 가치
    dp[0] = 0 // 배낭 용량 0이면 어차피 못넣음
    for (i in 0 until N) { // 각 물건을
        for(k in K downTo 1) { // 배낭의 용량을 1씩 줄여가며 넣는다.
            if (N[i].weight <= k) { // 배낭에 들어가면
                if (dp[k] < dp[k - N[i].weight] + N[i].value) { // 원래 저장된 가치의 최대값보다 크면
                    dp[k] = dp[k - N[i].weight] + N[i].value // 최대값 업데이트
                }
            }
        }
    }
    dp[K]의 값이 결과가 된다.
 */

fun main() {
    val K = 7
    val items = listOf(6 to 13, 4 to 8, 3 to 6, 5 to 12) // weight to value
    val N = items.size
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
