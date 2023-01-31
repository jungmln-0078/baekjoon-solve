val input1260 = readln().split(" ").map { it.toInt() }
val graph1260 = MutableList<MutableList<Int>>(input1260[0] + 1){ mutableListOf() }
val DFSVisited = MutableList(input1260[0] + 1){ false }
val DFSresult = mutableListOf<String>()
val BFSVisited = MutableList(input1260[0] + 1){ false }
val BFSresult = mutableListOf<String>()
fun main() {
    for (i: Int in 1..input1260[1]) {
        val edge = readln().split(" ").map { it.toInt() }
        graph1260[edge[0]].add(edge[1])
        graph1260[edge[1]].add(edge[0])
    }
    graph1260.map { it.sort() }
    DFS1260(input1260[2])
    BFS1260(input1260[2])
    println(DFSresult.joinToString(" "))
    println(BFSresult.joinToString(" "))
}

fun DFS1260(start: Int) {
    if (DFSVisited[start]) return
    DFSVisited[start] = true
    val curNode = graph1260[start]
    DFSresult.add(start.toString())
    for (i: Int in curNode.indices) {
        if (!DFSVisited[curNode[i]]) DFS1260(curNode[i])
    }
}

fun BFS1260(start: Int) {
    val queue = mutableListOf<Int>()
    BFSVisited[start] = true
    queue.add(start)
    while (queue.isNotEmpty()) {
        val n = queue.first()
        queue.removeFirst()
        BFSresult.add(n.toString())
        for (i: Int in graph1260[n]) {
            if (!BFSVisited[i])  {
                BFSVisited[i] = true
                queue.add(i)
            }
        }
    }
}
