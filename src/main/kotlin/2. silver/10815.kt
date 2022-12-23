fun main() {
    readln()
    val cards = readln().split(" ").map { it.toInt() }.sorted()
    readln()
    val search = readln().split(" ").map { it.toInt() }
    val result = mutableListOf<String>()
    for (s: Int in search) {
        result.add(binarySearch10815(cards, s))
    }
    println(result.joinToString(" "))
}

fun binarySearch10815(list: List<Int>, find: Int): String {
    var first = 0
    var last = list.lastIndex

    while (first <= last) {
        val midIdx = (first + last) / 2
        val mid = list[midIdx]
        if (find == mid) {
            return "1"
        } else if (find > mid) {
            first = midIdx + 1
        } else if (find < mid) {
            last = midIdx - 1
        }
    }
    return "0"
}
