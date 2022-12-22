import java.math.BigInteger
import kotlin.math.pow
// 50점
fun main() {
    readln()
    val raw = readln()
    var hash = BigInteger.valueOf(0)
    for (i: Int in 0..raw.lastIndex) {
        val c = raw[i]
        hash += (c.code - 96).toBigInteger() * 31.toDouble().pow(i).toBigDecimal().toBigInteger()
    }
    println(hash % 1234567891.toBigInteger())
}
