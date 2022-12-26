import java.math.BigInteger

fun main() {
    val N = readln().toInt()
    var result = 0
    val fac = factorial1676(N).toString()
    for (n: Int in fac.indices.reversed()) {
        if (fac[n] == '0') result++
        else break
    }
    println(result)
}

fun factorial1676(n: Int): BigInteger {
    var result = BigInteger.valueOf(1)
    (1..n).forEach { result *= it.toBigInteger() }
    return result
}
