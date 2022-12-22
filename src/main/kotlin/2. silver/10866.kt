fun main() {
    val lineCount = readln().toInt()
    var deque = mutableListOf<Int>()
    for (i: Int in 1..lineCount) {
        val command = readln().split(" ")
        when(command[0]) {
            "push_front" -> {
                val param = command[1].toInt()
                deque.add(param)
            }
            "push_back" -> {
                val param = command[1].toInt()
                deque = (listOf(param) + deque).toMutableList()
            }
            "pop_front" -> {
                if (deque.isEmpty()) {
                    println(-1)
                } else {
                    println(deque.last())
                    deque.removeLast()
                }
            }
            "pop_back" -> {
                if (deque.isEmpty()) {
                    println(-1)
                } else {
                    println(deque.first())
                    deque.removeFirst()
                }
            }
            "size" -> println(deque.size)
            "empty" -> println(if(deque.isEmpty()) 1 else 0)
            "front" -> {
                if (deque.isEmpty()) {
                    println(-1)
                } else {
                    println(deque.last())
                }
            }
            "back" -> {
                if (deque.isEmpty()) {
                    println(-1)
                } else {
                    println(deque.first())
                }
            }
        }
    }
}
