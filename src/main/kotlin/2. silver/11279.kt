import java.util.Collections
import java.util.PriorityQueue

fun main() {
    val priorityQueue = PriorityQueue<Int>(Collections.reverseOrder())
    val N = readln().toInt()
    for (i: Int in 1..N) {
        val x = readln().toInt()
        if (x == 0) {
            println(priorityQueue.poll() ?: 0)
        } else {
            priorityQueue.add(x)
        }
    }
}
