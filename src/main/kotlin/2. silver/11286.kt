import java.util.PriorityQueue
import kotlin.math.abs

fun main() {
    val priorityQueue = PriorityQueue(Comparator<Int>() { v1, v2 ->
        if (abs(v1) - abs(v2) == 0)
            v1 - v2
        else abs(v1) - abs(v2)
    })
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
