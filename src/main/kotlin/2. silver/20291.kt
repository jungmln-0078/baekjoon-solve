fun main() {
    val N = readln().toInt()
    val count = mutableMapOf<String, Int>()
    for (i in 1..N) {
        val extension = readln().split(".")[1]
        if (count[extension] == null) count[extension] = 1
        else count[extension] = count[extension]!! + 1
    }
    count.toSortedMap().forEach { println("${it.key} ${it.value}") }
}
