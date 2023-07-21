fun main() {
    val (N, Q, C) = readln().split(" ").map { it.toInt() }
    val cacheSizeInput = readln().split(" ").map { it.toInt() }
    val cacheSize = mutableMapOf<Int, Int>()
    cacheSizeInput.forEachIndexed { index, i -> cacheSize[index + 1] = i }
    var back = mutableListOf<Int>()
    val front = mutableListOf<Int>()
    var cache = 0
    var location = 0
    for (i: Int in 1..Q) {
        val cmd = readln().split(" ")
        when (cmd[0]) {
            "A" -> {
                val temp = location
                location = cmd[1].toInt()
                cache += cacheSize[location]!!
                front.forEach { cache -= cacheSize[it]!! }
                front.clear()
                if (temp != 0) {
                    back.add(temp)
                    while (cache > C) {
                        val old = back.first()
                        cache -= cacheSize[old]!!
                        back.removeFirst()
                    }
                }
            }
            "B" -> {
                if (back.isNotEmpty()) {
                    front.add(0, location)
                    location = back.last()
                    back.removeLast()
                }
            }
            "F" -> {
                if (front.isNotEmpty()) {
                    back.add(location)
                    location = front.first()
                    front.removeFirst()
                }
            }
            "C" -> {
                val newBack = mutableListOf<Int>()
                for (b in back) {
                    if (newBack.isEmpty() || newBack.last() != b) newBack.add(b)
                    else cache -= cacheSize[b]!!
                }
                back = newBack
            }
        }
    }
    println(location)
    println(if (back.isEmpty()) -1 else back.reversed().joinToString(" "))
    println(if (front.isEmpty()) -1 else front.joinToString(" "))
}
