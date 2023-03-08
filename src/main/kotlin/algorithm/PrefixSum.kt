package main.kotlin.algorithm
const val N = 10
val arr = mutableListOf(0, 2, 4, 5, 7, 6, 1, 9, 3, 8)
val sum = MutableList(N) { 0 }
fun main() {
    for (i: Int in 1 until N) {
        sum[i] = sum[i - 1] + arr[i]
    }

    println(prefixSum(1, 4))
    println(prefixSum(3, 6))
}

fun prefixSum(start: Int, end: Int): Int {
    return sum[end] - sum[start - 1]
}
