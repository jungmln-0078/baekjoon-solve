fun main() {
    /**
     * A * B
     * { A1 A2 }
     * { A3 A4 }
     * { A5 A6 }
     *
     * { B1 B2 B3 }
     * { B4 B5 B6 }
     *
     * N, M * M, K
     *
     * A[N][M]
     * B[M][K]
     *
     * result[i][j] = A[i][0 until M] B[0 until M][j]
     */
    val (N, M) = readln().split(" ").map { it.toInt() }
    val A = mutableListOf<List<Int>>()
    for (i: Int in 1..N) {
        A.add(readln().split(" ").map { it.toInt() })
    }

    val K = readln().split(" ")[1].toInt()
    val B = mutableListOf<List<Int>>()
    for (i: Int in 1..M) {
        B.add(readln().split(" ").map { it.toInt() })
    }

    val result = MutableList(N) { MutableList(K) { 0 } }

    for (i: Int in 0 until N) {
        for (j: Int in 0 until K) {
            result[i][j] = (0 until M).fold(0) { total, idx ->
                total + A[i][idx] * B[idx][j]
            }
        }
    }

    println(result.joinToString("\n") { it.joinToString(" ") })
}
