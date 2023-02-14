var graph = mutableMapOf<Pair<Int, Int>, MutableList<Pair<Int, Int>>>()
var graphVisited = mutableMapOf<Pair<Int, Int>, Boolean>()

fun main() {
    val tcCount = readln().toInt()
    for (t: Int in 1..tcCount) {
        val input = readln().split(" ")
        val x = input[0].toInt()
        val y = input[1].toInt()
        val baechu = input[2].toInt()
        for (i: Int in 1..baechu) {
            val apex = readln().split(" ").map { it.toInt() }
            graph[apex[0] to apex[1]] = mutableListOf()
            graphVisited[apex[0] to apex[1]] = false
            if (apex[0] - 1 >= 0 && graph[apex[0] - 1 to apex[1]] != null) {
                graph[apex[0] to apex[1]]?.add(apex[0] - 1 to apex[1])
                graph[apex[0] - 1 to apex[1]]?.add(apex[0] to apex[1])
            }
            if (apex[0] + 1 <= x && graph[apex[0] + 1 to apex[1]] != null) {
                graph[apex[0] to apex[1]]?.add(apex[0] + 1 to apex[1])
                graph[apex[0] + 1 to apex[1]]?.add(apex[0] to apex[1])
            }
            if (apex[1] - 1 >= 0 && graph[apex[0] to apex[1] - 1] != null) {
                graph[apex[0] to apex[1]]?.add(apex[0] to apex[1] - 1)
                graph[apex[0] to apex[1] - 1]?.add(apex[0] to apex[1])
            }
            if (apex[1] + 1 <= y && graph[apex[0] to apex[1] + 1] != null) {
                graph[apex[0] to apex[1]]?.add(apex[0] to apex[1] + 1)
                graph[apex[0] to apex[1] + 1]?.add(apex[0] to apex[1])
            }
        }
        var cnt = 0
        while (true) {
            graph = graph.filter { graphVisited[it.key] != true }.toMutableMap()
            if (graph.isEmpty()) break
            cnt++
            graphDFS(graph.keys.first())
        }
        println(cnt)
        graph = mutableMapOf()
        graphVisited = mutableMapOf()
    }
}

fun graphDFS(start: Pair<Int, Int>) {
    if (graphVisited[start] == true) return
    graphVisited[start] = true
    val curNode = graph[start]!!
    for (i: Int in curNode.indices) {
        if (graphVisited[curNode[i]] != true) graphDFS(curNode[i])
    }
}
