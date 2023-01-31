fun main() {
    val tcCount = readln().toInt()
    var command = ""
    var list: ArrayDeque<String>
    for (i: Int in 1..tcCount * 3) {
        var d = true
        when (i % 3) {
            1 -> command = readln()
            2 -> readln()
            0 -> {
                val l = readln()
                val arrayString = l.filter { it != '[' && it != ']' }
                list = ArrayDeque(if (arrayString.isEmpty()) listOf() else arrayString.split(",").toList())
                var backward = false
                for (c: Char in command) {
                    when (c) {
                        'R' -> {
                            backward = !backward
                        }
                        'D' -> {
                            if (list.size == 0) {
                                println("error")
                                d = false
                                break
                            }
                            if (backward) {
                                list.removeLast()
                            } else {
                                list.removeFirst()
                            }
                        }
                    }
                }
                if (d) {
                    if (backward) {
                        list.reverse()
                    }
                    println('[' + list.joinToString(",") + ']')
                }
            }
        }
    }
}
