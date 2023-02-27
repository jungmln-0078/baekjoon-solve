fun main() {
    val N = readln().toInt()
    val map = mutableMapOf<String, Boolean?>()
    var result = 0
    for (i: Int in 1..N) {
        val input = readln()
        if (input == "ENTER") {
            map.clear()
        } else if (map[input] == null) {
            result++
            map[input] = true
        }
    }
    println(result)
}
