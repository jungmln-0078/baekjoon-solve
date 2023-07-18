// 다익스트라 알고리즘
fun main() {
    val N = readln().toInt()
    val M = readln().toInt()
    val nodes = MutableList<MutableList<Pair<Int, Int>>>(N) { mutableListOf() }
    val distances = MutableList(N){ Int.MAX_VALUE }
    for (i: Int in 1..M) {
        val input = readln().split(" ").map{ it.toInt() }
        nodes[input[0] - 1].add(input[1] - 1 to input[2])
    }
    val input = readln().split(" ").map { it.toInt() }
    val start = input[0] - 1
    val end = input[1] - 1
    distances[start] = 0
    val queue = mutableListOf<Pair<Int, Int>>()
    queue.add(start to 0)
    while (queue.isNotEmpty()) {
        val first = queue.first()
        val curNode = nodes[first.first]
        val distance = first.second
        queue.removeFirst()
        if (distances[first.first] < distance) continue
        for (node: Pair<Int, Int> in curNode) {
            if (node.second + distance < distances[node.first]) {
                distances[node.first] = node.second + distance
                queue.add(node.first to distances[node.first])
            }
        }
    }
    println(distances[end])
}
