fun main() {
    val input = readln().split(" ")
    val n = input[0].toInt()
    val d = input[1]
    var count = 0
    for (i: Int in 1..n) {
        count += i.toString().count{ it == d[0] }
    }
    println(count)
}
