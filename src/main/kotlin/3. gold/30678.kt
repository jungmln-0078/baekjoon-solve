import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val pow5 = listOf(
        1, 5, 25, 125, 625, 3125
    )
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    val A = pow5[N]

    val star = MutableList(A) { MutableList(A) { " " } }
    val offsets = listOf(
        0 to 2,
        1 to 2,
        2 to 0,
        2 to 1,
        2 to 2,
        2 to 3,
        2 to 4,
        3 to 1,
        3 to 2,
        3 to 3,
        4 to 1,
        4 to 3
    )
    if (N == 0) {
        bw.append("*")
        bw.flush()
        return
    }
    data class StarData(val i: Int, val offset: Pair<Int, Int>)
    val starQueue = LinkedList<StarData>()
    starQueue.add(StarData(N, 0 to 0))
    while (starQueue.isNotEmpty()) {
        val starData = starQueue.removeFirst()
        val i = starData.i
        val offset = starData.offset
        val p = pow5[i - 1]
        for ((y, x) in offsets) {
            if (i == 1) star[y + offset.first][x + offset.second] = "*"
            else starQueue.add(StarData(i - 1, y * p + offset.first to x * p + offset.second))
        }
    }

    bw.append(star.joinToString("\n") { it.joinToString("")})
    bw.flush()
}
