fun main() {
    readln()
    val list = readln().split(" ").map { it.toInt() }.sorted()
    readln()
    val search = readln().split(" ").map { it.toInt() }

    for (find in search) {
        println(binarySearch(list, find))
    }
}

fun binarySearch(list: List<Int>, find: Int): Int {
    var first = 0
    var last = list.lastIndex

    while (first <= last) {
        val midIdx = (first + last) / 2
        val mid = list[midIdx]
        if (find == mid) {
            return 1
        } else if (find > mid) {
            first = midIdx + 1
        } else if (find < mid) {
            last = midIdx - 1
        }
    }
    return 0
}
