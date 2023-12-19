fun main() {
    val N = readln().toInt()
    val graph = MutableList(N + 1) { mutableListOf<Int>() }
    val visited = mutableMapOf<Int, Boolean>()
    val parent = mutableMapOf<Int, Int>()
    (1..N).forEach {
        visited[it] = false
        parent[it] = 0
    }

    for (i: Int in 1 until N) {
        val vertex = readln().split(" ").map { it.toInt() }
        graph[vertex[0]].add(vertex[1])
        graph[vertex[1]].add(vertex[0])
    }

    fun DFS(start: Int, before: Int) {
        visited[start] = true
        parent[start] = before
        for (child: Int in graph[start]) {
            if (!visited[child]!!) DFS(child, start)
        }
    }

    DFS(1, 0)

    (2..N).forEach { println(parent[it]) }
}
