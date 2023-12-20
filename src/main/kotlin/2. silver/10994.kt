import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    val A = 1 + 2 * (N - 1) * 2
    val stars = MutableList(A) { MutableList(A) { " " } }

    fun star(n: Int) {
        val offset = (N - n) * 2
        val start = 0 + offset
        val end = if (A - offset - 1 < 0) 0 else A - offset - 1

        for (x: Int in start .. end) {
            stars[start][x] = "*"
            stars[end][x] = "*"
            stars[x][start] = "*"
            stars[x][end] = "*"
        }
        if (n > 1) star(n - 1)
    }
    star(N)
    bw.append(stars.joinToString("\n") { it.joinToString("") })
    bw.flush()
}
