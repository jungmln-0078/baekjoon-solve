import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var arr11659 = mutableListOf(0)
var sum11659 = mutableListOf<Int>()
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    sum11659 = MutableList(N + 1){ 0 }
    arr11659.addAll(br.readLine().split(" ").map { it.toInt() })
    for (i: Int in 1 .. N) {
        sum11659[i] = sum11659[i - 1] + arr11659[i]
    }

    for (i: Int in 1..M) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        bw.write(prefixSum(a, b).toString() + "\n")
    }
    bw.flush()
    br.close()
    bw.close()
}

fun prefixSum(start: Int, end: Int): Int {
    return sum11659[end] - sum11659[start - 1]
}
