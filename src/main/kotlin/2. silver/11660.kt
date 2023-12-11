fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val matrix = mutableListOf<MutableList<Int>>()
    val query = mutableListOf<Pair<Pair<Int, Int>, Pair<Int, Int>>>()
    val sum = MutableList(N + 1) { MutableList(N + 1) { 0 } }

    for (i: Int in 1..N) {
        val matrixRow = readln().split(" ").map { it.toInt() }.toMutableList()
        matrix.add(matrixRow)
    }

    for (i: Int in 1..M) {
        query.add(readln().split(" ").map { it.toInt() }.let { (it[0] to it[1]) to (it[2] to it[3]) })
    }

    for (i: Int in 1 ..  N) {
        for (j: Int in 1 .. N) {
            sum[i][j] = sum[i][j - 1] + sum[i - 1][j] + matrix[i - 1][j - 1] - sum[i - 1][j - 1]
            /**
             * sum[0][0] = 0
             * sum[0][j] = 0
             * sum[i][0] = 0
             * matrix[0][0] ~ matrix[i-1][j-1] 까지의 누적합을 sum[i][j]에 저장한다.
             *
             * sum[i][j] = sum[i-1][j] + sum[i][j-1] + matrix[i-1][j-1] - sum[i-1][j-1]
             *
             * 1. matrix[0][0] ~ matrix[i-1][j-2] 까지의 합과 matrix[0][0] ~ matrix[i-2][j-1] 까지의 합, 행렬의 현재 위치의 값을 더해준다.
             * 2. 이때 matrix[0][0] ~ matrix[i-2][j-2] 까지의 누적합이 두 번 더해지므로 sum[i-1][j-1]의 값을 빼준다.
             */
        }
    }

    for ((startPos, endPos) in query) {
        val ey = endPos.first
        val ex = endPos.second
        val sy = startPos.first
        val sx = startPos.second
        println(sum[ey][ex] // 끝 좌표 까지의 누적합 matrix[0][0] ~ matrix[ey-1][ex-1]
                - sum[sy - 1][ex] // 끝 좌표 기준 맨 위쪽 좌표까지의 누적합 을 빼준다. matrix[0][0] ~ matrix[sy-2][ex-1]
                - sum[ey][sx - 1]  // 끝 좌표 기준 맨 왼쪽 좌표까지의 누적합 을 빼준다. matrix[0][0] ~ matrix[ey-1][sx-2]
                + sum[sy - 1][sx - 1]) // 위 두 과정에서 matrix[0][0] ~ matrix[sy-2][sx-2] 까지의 값이 두번 빼졌기 때문에 한 번 더해준다.

    }
}
