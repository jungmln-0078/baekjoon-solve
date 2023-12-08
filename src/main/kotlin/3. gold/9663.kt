import kotlin.math.abs

fun main() {
    val N = readln().toInt()
    val rowBoard = BooleanArray(N) { false } // 각 행별 퀸이 놓였는지 index가 행번호
    /**
     * 각 칸의 숫자가 rightUpDiagonalBoard의 index
     *   00 01 02 03 04 05 06 07
     * 0 00 01 02 03 04 05 06 07
     * 1 01 02 03 04 05 06 07 08
     * 2 02 03 04 05 06 07 08 09
     * 3 03 04 05 06 07 08 09 10
     * 4 04 05 06 07 08 09 10 11
     * 5 05 06 07 08 09 10 11 12
     * 6 06 07 08 09 10 11 12 13
     * 7 07 08 09 10 11 12 13 14
     */
    val rightUpDiagonalBoard = BooleanArray(N * 2 - 1) { false } // 우상 대각선 방향에 퀸이 놓였는지
    /**
     * 각 칸의 숫자가 leftDownDiagonalBoard의 index
     *   00 01 02 03 04 05 06 07
     * 7 07 08 09 10 11 12 13 14
     * 6 06 07 08 09 10 11 12 13
     * 5 05 06 07 08 09 10 11 12
     * 4 04 05 06 07 08 09 10 11
     * 3 03 04 05 06 07 08 09 10
     * 2 02 03 04 05 06 07 08 09
     * 1 01 02 03 04 05 06 07 08
     * 0 00 01 02 03 04 05 06 07
     */
    val leftDownDiagonalBoard = BooleanArray(N * 2 - 1) { false } // 좌하 대각선 방향에 퀸이 놓였는지
    var result = 0

    fun nQueen(colNum: Int) {
        // 끝까지 탐색했으면 N개 만큼 놓을 수 있다고 간주하여 경우의수 + 1
        if (colNum == N) {
            result++
            return
        }
        // 현재 열의 각 행에 대하여
        for (i: Int in 0 until N) {
            // 놓을 수 있으면
            if (!rowBoard[i] && !rightUpDiagonalBoard[colNum + i] && !leftDownDiagonalBoard[colNum + (N - 1 - i)]) {
                // 놓고
                rowBoard[i] = true
                rightUpDiagonalBoard[colNum + i] = true
                leftDownDiagonalBoard[colNum + (N - 1 - i)] = true
                // 다음 열로 넘어간다.
                nQueen(colNum + 1)
                // 백트래킹을 위해 현재 상태를 초기화한다.
                rowBoard[i] = false
                rightUpDiagonalBoard[colNum + i] = false
                leftDownDiagonalBoard[colNum + (N - 1 - i)] = false
            }
        }
    }
    nQueen(0)
    println(result)
}
