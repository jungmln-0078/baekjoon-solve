fun main() {
    val a = readln().split(" ").map { it.toInt() }.toMutableList()
    val b = readln().split(" ").map { it.toInt() }.toMutableList()

    val lcm = lcm(a[1], b[1])
    val mulA = lcm / a[1]
    val mulB = lcm / b[1]
    a[0] = mulA * a[0]
    b[0] = mulB * b[0]
    val gcd = gcd(a[0] + b[0], lcm)
    println("${(a[0] + b[0]) / gcd} ${lcm / gcd}")
}

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a
    else gcd(b, a % b)
}

fun lcm(a: Int, b: Int): Int {
    return (a * b) / gcd(a, b)
}
