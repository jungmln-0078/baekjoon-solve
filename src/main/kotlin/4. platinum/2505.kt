fun main() {
    val N = readln().toInt()
    val tobeList = (1..N).toList()
    val originList = readln().split(" ").map { it.toInt() }.toList()
    var list: MutableList<Int> = ArrayList(originList)
    val result = mutableListOf<Pair<Int, Int>>()
    while (true) {
        var startPos = -1
        var endPos = -1
        for (i: Int in list.indices) {
            if (startPos == -1 && list[i] != i + 1) startPos = i
            if (endPos == -1 && list[i] == startPos + 1) endPos = i
        }
        if (startPos == -1 && endPos == -1) break
        reverse2505(list, startPos, endPos)
        result.add(startPos + 1 to endPos + 1)
        if (list == tobeList) break
    }
    if (result.size > 2) {
        result.clear()
        list = ArrayList(originList)
        while (true) {
            var startPos = -1
            var endPos = -1
            for (i: Int in list.indices.reversed()) {
                if (endPos == -1 && list[i] != i + 1) endPos = i
                if (startPos == -1 && list[i] == endPos + 1) startPos = i
            }
            if (startPos == -1 && endPos == -1) break
            reverse2505(list, startPos, endPos)
            result.add(startPos + 1 to endPos + 1)
            if (list == tobeList) break
        }
    }
    if (result.size == 0) result.add(1 to 1)
    if (result.size == 1) result.add(1 to 1)
    println(result.joinToString("\n"){"${it.first} ${it.second}"})
}

fun reverse2505(list: MutableList<Int>, startIdx: Int, endIdx: Int) {
    var temp: Int
    for (i: Int in endIdx downTo endIdx - ((endIdx - startIdx) / 2)) {
        temp = list[i]
        list[i] = list[startIdx + endIdx - i]
        list[startIdx + endIdx - i] = temp
    }
}
