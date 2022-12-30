fun main() {
    while (true) {
        val input = readln().split(" ")
        val N = input[0].toInt()
        val M = input[1].toInt()
        if (N == 0 && M == 0) break
        val nList = mutableListOf<Int>()
        val mList = mutableListOf<Int>()
        var result = 0
        for (i: Int in 1..N) {
            nList.add(readln().toInt())
        }
        for (i: Int in 1..M) {
            mList.add(readln().toInt())
        }
        if (N >= M) {
            nList.forEach {
                result += binarySearch4158(mList, it)
            }
        } else {
            mList.forEach {
                result += binarySearch4158(nList, it)
            }
        }
        println(result)
    }
}

fun binarySearch4158(list: List<Int>, find: Int): Int {
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
