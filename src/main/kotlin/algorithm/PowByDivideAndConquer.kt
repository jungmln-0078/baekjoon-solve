package algorithm

import kotlin.math.pow

/* 분할 정복으로 거듭제곱 구하기
https://mygumi.tistory.com/319
n^r을 n^(r/2)로 분할 후 서로 곱함
r이 홀수면 n을 곱하고 return
r == 0인 경우 1 return
 */
fun main() {
    println(powByDivideAndConquer(2, 4))
    println(2.toDouble().pow(4.toDouble()).toInt())
    println(powByDivideAndConquer(2, 5))
    println(2.toDouble().pow(5.toDouble()).toInt())
}

fun powByDivideAndConquer(n: Int, r: Int): Int {
    var n = n
    var r = r
    var result = 1
    while (r > 0) {
        if (r % 2.toLong() == 1.toLong()) {
            result *= n
        }
        n *= n
        r /= 2
    }
    return result
}
