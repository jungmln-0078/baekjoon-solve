fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val N = input[0]
    val M = input[1]
    val dnas = mutableListOf<String>()
    var result = ""
    var hammingDistance = 0

    for (i: Int in 1..N) {
        dnas.add(readln())
    }

    for (row : Int in 0 until M) {
        val map = mutableMapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0)
        for (column: Int in 0 until N) {
            map[dnas[column][row]] = map[dnas[column][row]]!! + 1
        }
        val max = map.filter { m -> m.value == map.maxWith(compareBy { it.value }).value }.keys.toList()[0]
        result += max
        hammingDistance += map.entries.filter { it.key != max }.sumOf { it.value }
    }

    println(result)
    println(hammingDistance)
}
