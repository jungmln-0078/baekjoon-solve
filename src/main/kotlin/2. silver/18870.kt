fun main() {
    readln()
    val list = readln().split(" ").map { it.toInt() }
    val sorted = list.sorted().distinct()
    val compressed = mutableListOf<Int>()
    for (num: Int in list) {
        compressed.add(binarySearch_(sorted, num))
    }
    println(compressed.joinToString(" "))
}

fun binarySearch_(list: List<Int>, find: Int): Int {
    var first = 0
    var last = list.lastIndex

    while (first <= last) {
        val midIdx = (first + last) / 2
        val mid = list[midIdx]
        if (find == mid) {
            return midIdx
        } else if (find > mid) {
            first = midIdx + 1
        } else if (find < mid) {
            last = midIdx - 1
        }
    }
    return 0
}
