fun main() {
    readln()
    val rawMap = readln().split(" ").map { it.toInt() }
    val map = HashMap<Int, Int>()
    rawMap.forEach { map[it] = if (map[it] == null) 1 else map[it]!! + 1 }
    readln()
    val search =  readln().split(" ").map { it.toInt() }
    val result = mutableListOf<Int>()
    search.forEach {
        result.add(map[it] ?: 0)
    }
    println(result.joinToString(" "))
}
