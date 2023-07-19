fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val deque = (1..N).toMutableList()
    val target = readln().split(" ").map { it.toInt() }.toMutableList()
    var result = 0
    while (target.isNotEmpty()) {
        val t = target.first()
        val size = deque.size
        val idx = deque.indexOf(t)
        if (t == deque.first()) {
            deque.removeFirst()
            target.removeFirst()
        } else if (t == deque.last()) {
            result++
            deque.removeLast()
            target.removeFirst()
        } else if (size - idx >= idx) {
            result += idx
            for (i: Int in 0 until idx) {
                deque.add(deque.first())
                deque.removeFirst()
            }
            deque.removeFirst()
            target.removeFirst()
        } else if (size - idx < idx) {
            result += size - idx
            for (i: Int in 0 until size - idx) {
                deque.add(0, deque.last())
                deque.removeLast()
            }
            deque.removeFirst()
            target.removeFirst()
        }
    }
    println(result)
}
