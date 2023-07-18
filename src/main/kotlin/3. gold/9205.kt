import kotlin.math.abs

fun main() {
    val tcCount = readln().toInt()
    for (tc in 1..tcCount) {
        val storeCount = readln().toInt()
        val N = storeCount + 2
        val graph = mutableMapOf<Pair<Int, Int>, MutableList<Pair<Int, Int>>>()
        val graphBFSVisited = mutableMapOf<Pair<Int,Int>, Boolean>()
        var start: Pair<Int, Int> = 0 to 0
        var end: Pair<Int, Int> = 0 to 0

        fun BFS(start: Pair<Int, Int>): String {
            val queue = mutableListOf<Pair<Int, Int>>()
            graphBFSVisited[start] = true
            queue.add(start)
            while (queue.isNotEmpty()) {
                val n = queue.first()
                queue.removeFirst()
                if(n == end) return "happy"
                for (i: Pair<Int, Int> in graph[n]!!) {
                    if (!graphBFSVisited[i]!!)  {
                        graphBFSVisited[i] = true
                        queue.add(i)
                    }
                }
            }
            return "sad"
        }

        for (i in 1..N) {
            val node = readln().split(" ").map { it.toInt() }.let { it[0] to it[1] }
            if (i == 1) start = node
            if (i == N) end = node
            graph[node] = mutableListOf()
            graphBFSVisited[node] = false
        }
        graph.keys.forEach { node ->
            val childKeys = graph.keys.filter { abs(it.first - node.first) + abs(it.second - node.second) <= 1000 && it != node }
            childKeys.forEach {
                graph[it]!!.add(node)
            }
        }
        println(BFS(start))
    }
}
