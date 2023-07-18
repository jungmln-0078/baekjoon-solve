import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (V, E) = br.readLine().split(" ").map { it.toInt() }
    val K = br.readLine().toInt()
    val nodes = Array<MutableList<Pair<Int, Int>>>(V) { mutableListOf() }
    val distances = Array(V){ Int.MAX_VALUE }
    for (i: Int in 1..E) {
        val input = br.readLine().split(" ").map{ it.toInt() }
        nodes[input[0] - 1].add(input[2] to input[1] - 1)
    }
    distances[K - 1] = 0
    val lambda = {a: Int, b: Int -> when {
        a > b -> 1
        a < b -> -1
        else -> 0
    }}
    val queue = PriorityQueue<Pair<Int, Int>>(E) { o1, o2 ->
        val r = lambda(o1.first, o2.first)
        if (r == 0) if (o1.second <= o2.second) -1 else 1
        else r
    }
    queue.add(0 to K - 1)
    while (queue.isNotEmpty()) {
        val first = queue.poll()
        val curNode = nodes[first.second]
        val distance = first.first
        if (distances[first.second] < distance) continue
        for (node: Pair<Int, Int> in curNode) {
            if (node.first + distance < distances[node.second]) {
                distances[node.second] = node.first + distance
                queue.add(distances[node.second] to node.second)
            }
        }
    }

    for (i: Int in distances.indices) {
        if (distances[i] == Int.MAX_VALUE) bw.append("INF")
        else bw.append(distances[i].toString())
        if (i != distances.lastIndex) bw.append("\n")
    }
    bw.flush()
    bw.close()
}
