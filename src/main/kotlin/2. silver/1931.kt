fun main() {
    val N = readln().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    var result = 0
    for (i: Int in 1..N) {
        val input = readln().split(" ")
        list.add(input[0].toInt() to input[1].toInt())
    }
    list.sortWith(compareBy ({ it.second }, { it.first }))
    var time = 0
    for (i: Int in list.indices) {
        if (time <= list[i].first) {
            result++
            time = list[i].second
        }
    }
    println(result)
}
