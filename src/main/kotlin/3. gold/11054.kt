fun main() {
    val N = readln().toInt()
    val A = IntArray(N)
    val LIS = IntArray(N) { 0 }
    val LISReversed = IntArray(N) { 0 }
    val bitonic = IntArray(N) { 0 }

    readln().split(" ").forEachIndexed { idx, a -> A[idx] = a.toInt() }

    for (i: Int in A.indices) {
        var lis = 0
        for (j: Int in 0 until i) {
            if (A[j] < A[i] && LIS[j] > lis) lis = LIS[j]
        }
        LIS[i] = lis + 1
    }
    for (i: Int in A.indices.reversed()) {
        var lis = 0
        for (j: Int in A.lastIndex downTo i) {
            if (A[j] < A[i] && LISReversed[j] > lis) lis = LISReversed[j]
        }
        LISReversed[i] = lis + 1
    }

    for (i: Int in A.indices) {
        bitonic[i] = LIS[i] + LISReversed[i] - 1
    }

    println(bitonic.max())
}
