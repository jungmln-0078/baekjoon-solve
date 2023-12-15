fun main() {
    val N = readln().toInt()
    val A = IntArray(N)
    val LIS = IntArray(N) { 0 }

    readln().split(" ").forEachIndexed { idx, a -> A[idx] = a.toInt() }

    for (i: Int in A.indices) {
        var lis = 0
        for (j: Int in 0 until i) {
            if (A[j] < A[i] && LIS[j] > lis) lis = LIS[j]
        }
        LIS[i] = lis + 1
    }

    println(LIS.max())
}
