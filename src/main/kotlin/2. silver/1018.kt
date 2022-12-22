fun main() {
    val mn = readln().split(" ")
    val M = mn[1].toInt()
    val N = mn[0].toInt()
    val board = mutableListOf<MutableList<Char>>()
    val results = mutableListOf<Int>()
    for (i: Int in 0 until N) {
        board.add(i, readln().toCharArray().toMutableList())
    }
    for (x: Int in 0.. N - 8) {
        for (y: Int in 0.. M - 8) {
            var cnt1 = 0
            var cnt2 = 0
            for (i: Int in 0 + x until 8 + x) {
                for (j: Int in 0 + y until 8 + y) {
                    if (j % 2 == 0 + (i % 2) && board[i][j] != 'W') cnt1++
                    if (j % 2 == 1 - (i % 2) && board[i][j] != 'B') cnt1++
                    if (j % 2 == 0 + (i % 2) && board[i][j] != 'B') cnt2++
                    if (j % 2 == 1 - (i % 2) && board[i][j] != 'W') cnt2++
                }
            }
            results.add(cnt1)
            results.add(cnt2)
        }
    }
    println(results.min())
}
