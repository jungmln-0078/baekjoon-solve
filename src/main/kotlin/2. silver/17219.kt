fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val N = input[0]
    val M = input[1]
    val map = mutableMapOf<String, String>()
    val search = mutableListOf<String>()
    val result = mutableListOf<String>()

    for (i: Int in 1..N) {
        val pInput = readln().split(" ")
        map[pInput[0]] = pInput[1]
    }
    for (i: Int in 1..M) {
        search.add(readln())
    }
    for (str: String in search) {
        result.add(map[str]!!)
    }
    println(result.joinToString("\n"))
}
