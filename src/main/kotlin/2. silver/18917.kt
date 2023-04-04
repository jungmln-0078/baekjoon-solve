import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val M = br.readLine().toInt()
    var sum: Long = 0
    var xor: Long = 0
    for (i: Int in 1..M) {
        val input = br.readLine().split(" ").map { it.toInt() }
        when (input[0]) {
            1 -> {
                sum += input[1]
                xor = xor xor input[1].toLong()
            }
            2 -> {
                sum -= input[1]
                xor = xor xor input[1].toLong()
            }
            3 -> bw.write("$sum\n")
            4 -> bw.write("$xor\n")
        }
    }
    br.close()
    bw.flush()
    bw.close()
}
