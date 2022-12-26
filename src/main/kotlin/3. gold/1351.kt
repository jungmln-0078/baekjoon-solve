import java.math.BigInteger

val input1351 = readln().split(" ")
val N1351 = input1351[0].toBigInteger()
val P1351 = input1351[1].toBigInteger()
val Q1351 = input1351[2].toBigInteger()
val dp1351 = HashMap<BigInteger, BigInteger>()
fun main() {
    dp1351[0.toBigInteger()] = 1.toBigInteger()
    println(d1351(N1351))
}

fun d1351(n: BigInteger): BigInteger {
    if (dp1351[n] != null) return dp1351[n]!!
    dp1351[n] = d1351(n / P1351) + d1351(n / Q1351)
    return dp1351[n]!!
}
