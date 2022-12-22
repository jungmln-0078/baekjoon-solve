fun main() {
    val lineCount = readln().toInt()
    val queue = mutableListOf<Int>()

    for (i: Int in 1..lineCount) {
        val command = readln().split(" ")
        when (command[0]) {
            "push" -> {
                val value = command[1].toInt()
                queue.add(value)
            }
            "pop" -> {
                if (queue.isEmpty()) {
                    println(-1)
                    continue
                }
                println(queue.first())
                queue.removeFirst()
            }
            "size" -> println(queue.size)
            "empty" -> println(if(queue.isEmpty()) 1 else 0)
            "front" -> {
                if (queue.isEmpty()) {
                    println(-1)
                    continue
                }
                println(queue.first())
            }
            "back" -> {
                if (queue.isEmpty()) {
                    println(-1)
                    continue
                }
                println(queue.last())
            }
        }
    }
}
