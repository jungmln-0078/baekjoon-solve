val input = readln().split(" ")
val N10917 = input[0].toInt()
val M10917 = input[1].toInt()
val graph10917 = MutableList<MutableList<Int>>(N10917 + 1) { mutableListOf() }
val graphBFSVisited = MutableList(N10917 + 1){ false }
val graphBFSQueue = mutableListOf<Pair<Int, Int>>()
val results = mutableListOf<Int>()

fun main() {
    for (i: Int in 1..M10917) {
        val vertex = readln().split(" ").map { it.toInt() }
        graph10917[vertex[0]].add(vertex[1])
    }
    graphBFSVisited[1] = true
    graphBFSQueue.add(1 to 0)
    while (graphBFSQueue.isNotEmpty()) {
        graphBFS()
    }
    println(results.minOrNull() ?: -1)
}

fun graphBFS() {
    val n = graphBFSQueue.first()
    graphBFSQueue.removeFirst()
    if (n.first == N10917) results.add(n.second)
    for (i: Int in graph10917[n.first]) {
        if (!graphBFSVisited[i])  {
            graphBFSVisited[i] = true
            graphBFSQueue.add(i to n.second + 1)
        }
    }
}
