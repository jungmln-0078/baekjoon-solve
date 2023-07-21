fun main() {
    val (N, Q) = readln().split(" ").map { it.toInt() }
    var back = mutableListOf<Int>()
    val front = mutableListOf<Int>()
    var location = 0
    for (i: Int in 1..Q) {
        val cmd = readln().split(" ")
        when (cmd[0]) {
            "A" -> {
                if (location != 0) back.add(location)
                location = cmd[1].toInt()
                front.clear()
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
                }
                back = newBack
            }
        }
    }
    println(location)
    println(if (back.isEmpty()) -1 else back.reversed().joinToString(" "))
    println(if (front.isEmpty()) -1 else front.joinToString(" "))
}
