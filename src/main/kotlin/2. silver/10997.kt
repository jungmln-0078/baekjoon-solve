import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    val X = 1 + 2 * (N - 1) * 2
    val Y = if (X == 1) 1 else X + 2
    val stars = MutableList(Y) { MutableList(X) { " " } }

    fun star(n: Int) {
        val offset = (N - n) * 2
        val offset1 = max(N - (n - 1), 0) * 2
        val offset2 = max(offset - 2, 0)
        val topEnd = max(X - offset2 - 1, 0)
        val bottomEnd = offset + 2 * (n - 1) * 2
        val verticalEnd = max(Y - offset - 1, 0)
        val rightEnd = max(X - offset - 1, 0)

        for (i: Int in offset .. topEnd) {
            stars[offset][i] = "*" // 윗줄 그리기
        }

        for (i: Int in offset .. verticalEnd) {
            stars[i][offset] = "*" // 왼쪽줄 그리기
        }

        for (i: Int in offset1..verticalEnd) {
            stars[i][rightEnd] = "*" // 오른쪽줄 그리기
        }

        for (i: Int in offset .. bottomEnd) {
            stars[verticalEnd][i] = "*" // 아랫줄 그리기
        }

        if (n > 1) star(n - 1)
    }
    if (N > 1) {
        stars[1].clear()
        stars[1].add("*")
    }

    star(N)
    bw.append(stars.joinToString("\n") { it.joinToString("") })
    bw.flush()
}
