fun main() {
    val input = readln().split(" ")
    val N = input[0].toInt()
    val M = input[1].toInt()
    val graph = MutableList<MutableList<Int>>(N + 1) { mutableListOf() }
    val graphBFSVisited = MutableList(N + 1){ false }
    val distance = MutableList(N + 1){ 0 }

    fun graphBFS(start: Int) {
        val queue = mutableListOf<Pair<Int, Int>>()
        graphBFSVisited[start] = true
        queue.add(start to 0)
        while (queue.isNotEmpty()) {
            val n = queue.first()
            queue.removeFirst()
            distance[n.first] = n.second
            for (i: Int in graph[n.first]) {
                if (!graphBFSVisited[i])  {
                    graphBFSVisited[i] = true
                    queue.add(i to n.second + 1)
                }
            }
        }
    }

    for (i: Int in 1..M) {
        val node = readln().split(" ").map { it.toInt() }
        graph[node[0]].add(node[1])
        graph[node[1]].add(node[0])
    }
    graphBFS(1)
    val maxDistance = distance.max()
    val minNumBarn = distance.indexOfFirst { it == maxDistance }
    val maxDistanceBarnCount = distance.count { it == maxDistance }
    print("$minNumBarn $maxDistance $maxDistanceBarnCount")
}
