val input11724 = readln().split(" ").map { it.toInt() }
val N11724 = input11724[0]
val M11724 = input11724[1]
val graph11724 = MutableList<MutableList<Int>>(N11724) { mutableListOf() }
val graphVisited11724 = MutableList(N11724) { false }
fun main() {
    for (i: Int in 1..M11724) {
        val edge = readln().split(" ").map { it.toInt() }
        graph11724[edge[0] - 1].add(edge[1] - 1)
        graph11724[edge[1] - 1].add(edge[0] - 1)
    }
    var answer = 0
    while (true) {
        val notVisited = graphVisited11724.indexOfFirst { !it }
        if (notVisited == -1) {
            println(answer)
            break
        }
        graphDFS11724(notVisited)
        answer++
    }
}

fun graphDFS11724(start: Int) {
    if (graphVisited11724[start]) return
    graphVisited11724[start] = true
    val curNode = graph11724[start]
    for (i: Int in curNode.indices) {
        if (!graphVisited11724[curNode[i]]) graphDFS11724(curNode[i])
    }
}
