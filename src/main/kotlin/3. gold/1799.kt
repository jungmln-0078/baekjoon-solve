import kotlin.system.exitProcess

fun main() {
    val N = readln().toInt()
    val DN = (N - 1) * 2 + 1
    val board = mutableListOf<MutableList<Int>>()
    val downDiagonal = MutableList(DN) { true }
    val upDiagonal = MutableList(DN) { true }
    val placeableCells = mutableListOf<Pair<Int, Int>>()
    val placed = mutableMapOf<Pair<Int, Int>, Boolean>()

    /*
        0 1 2 3 4
        1 2 3 4 5
        2 3 4 5 6
        3 4 5 6 7
        4 5 6 7 8


       4 5 6 7 8
       3 4 5 6 7
       2 3 4 5 6
       1 2 3 4 5
       0 1 2 3 4
    */

    for (i: Int in 0 until N) {
        val boardRow = readln().split(" ").map { it.toInt() }.toMutableList()
        board.add(boardRow)
        boardRow.forEachIndexed { index, placeable ->
            if (placeable == 1) {
                val down = i + index
                val up = (N - 1 - i) + index
                placeableCells.add(down to up)
                placed[down to up] = false
            }
        }
    }
    val diagonalPlaceable = placeableCells.groupBy { it.first }.toSortedMap()
    val lastIdx = diagonalPlaceable.lastKey()

    fun bishop(idx: Int) {
        println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ $idx")
        if (idx == lastIdx) {
            println(placed.values.count { it })
            return
        }
        val dp = diagonalPlaceable[idx] ?: listOf()
        if (dp.isEmpty()) bishop(idx + 1)
        var check = false
        for ((down, up) in dp) {
            println("down $down")
            println("up $up")
            println("downDiagonal $downDiagonal")
            println("upDiagonal $upDiagonal")
            println(placed.values.count { it })
            if (!placed[down to up]!! && downDiagonal[down] && upDiagonal[up]) {
                check = true
                placed[down to up] = true
                downDiagonal[down] = false
                upDiagonal[up] = false
                println("@@@@@@@@@@@ placed $down $up")
                bishop(idx + 1)
                placed[down to up] = false
                downDiagonal[down] = true
                upDiagonal[up] = true
            } else check = false
        }
        if (check) bishop(idx + 1)
    }
    bishop(0)
}
/*
0 1 2 5
9 10 7 4
 */
