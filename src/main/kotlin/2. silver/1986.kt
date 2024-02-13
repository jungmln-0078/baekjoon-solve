import kotlin.math.max

fun main() {
    val (n, m) = readln().split(' ').map{ it.toInt() }
    val o = max(n, m)
    val board = MutableList(n) { MutableList(m) { '1' } }
    val queenInput = readln().split(' ').map { it.toInt() }
    val queens = mutableListOf<Pair<Int, Int>>()
    val knightInput = readln().split(' ').map { it.toInt() }
    val knights = mutableListOf<Pair<Int, Int>>()
    val pawnInput = readln().split(' ').map { it.toInt() }
    val pawns = mutableListOf<Pair<Int, Int>>()

    if (queenInput.size > 1) {
        for (i: Int in 1 until queenInput.lastIndex step 2) {
            board[queenInput[i] - 1][queenInput[i + 1] - 1] = 'q'
            queens.add(queenInput[i] - 1 to queenInput[i + 1] - 1)
        }
    }

    if (knightInput.size > 1) {
        for (i: Int in 1 until knightInput.lastIndex step 2) {
            board[knightInput[i] - 1][knightInput[i + 1] - 1] = 'k'
            knights.add(knightInput[i] - 1 to knightInput[i + 1] - 1)
        }
    }

    if (pawnInput.size > 1) {
        for (i: Int in 1 until pawnInput.lastIndex step 2) {
            board[pawnInput[i] - 1][pawnInput[i + 1] - 1] = 'p'
            pawns.add(pawnInput[i] - 1 to pawnInput[i + 1] - 1)
        }
    }

    for ((x, y) in queens) {
        // 하
        for (i: Int in x downTo 0) {
            if (i == x) continue
            if (board[i][y] != '0' && board[i][y] != '1') break
            board[i][y] = '0'
        }
        // 상
        for (i: Int in x until n) {
            if (i == x) continue
            if (board[i][y] != '0' && board[i][y] != '1') break
            board[i][y] = '0'
        }
        // 좌
        for (i: Int in y downTo 0) {
            if (i == y) continue
            if (board[x][i] != '0' && board[x][i] != '1') break
            board[x][i] = '0'
        }
        // 우
        for (i: Int in y until m) {
            if (i == y) continue
            if (board[x][i] != '0' && board[x][i] != '1') break
            board[x][i] = '0'
        }
        // 좌상 대각선
        for (i: Int in 1 until o) {
            if ((x - i < 0 || y - i < 0) || board[x - i][y - i] != '0' && board[x - i][y - i] != '1') break
            board[x - i][y - i] = '0'
        }
        // 좌하 대각선
        for (i: Int in 1 until o) {
            if ((x + i >= n || y - i < 0) || board[x + i][y - i] != '0' && board[x + i][y - i] != '1') break
            board[x + i][y - i] = '0'
        }
        // 우상 대각선
        for (i: Int in 1 until o) {
            if ((x - i < 0 || y + i >= m) || board[x - i][y + i] != '0' && board[x - i][y + i] != '1') break
            board[x - i][y + i] = '0'
        }
        // 우하 대각선
        for (i: Int in 1 until o) {
            if ((x + i >= n || y + i >= m) || board[x + i][y + i] != '0' && board[x + i][y + i] != '1') break
            board[x + i][y + i] = '0'
        }
    }
    val knightPatterns = listOf(-1 to -2, -2 to -1, -2 to 1, -1 to 2, 1 to 2, 2 to 1, 2 to -1, 1 to -2)

    for ((x, y) in knights) {
        for ((px, py) in knightPatterns) {
            val newX = x + px
            val newY = y + py
            if (newX >= n || newX < 0 || newY >= m || newY < 0 || board[newX][newY] != '1') continue
            board[newX][newY] = '0'
        }
    }
    println(board.flatten().count { it == '1' })
}
