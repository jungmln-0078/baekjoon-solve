fun main() {
    val input = readln().split(" ")
    val N = input[0].toInt()
    val M = input[1].toInt()
    val strings = mutableMapOf<String, Boolean>()
    var result = 0
    for (i: Int in 1..N) {
        strings[readln()] = true
    }
    for (i: Int in 1..M) {
        if (strings[readln()] != null) {
            result++
        }
    }
    println(result)
}
