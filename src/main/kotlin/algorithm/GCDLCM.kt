package algorithm

fun main() {
    println(gcd(2, 4))
    println(lcm(2, 4))
}
// 최대공약수
fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a
    else gcd(b, a % b)
}

// 최소공배수
fun lcm(a: Int, b: Int): Int {
    return (a * b) / gcd(a, b)
}
