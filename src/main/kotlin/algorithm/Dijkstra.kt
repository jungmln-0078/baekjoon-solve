package main.kotlin.algorithm

/*
    다익스트라 알고리즘
    https://blog.naver.com/ndb796/221234424646
 */

fun main() {
    val N = 3 // 노드의 수
    val M = 4 // 간선의 수
    val nodes = MutableList<MutableList<Pair<Int, Int>>>(N) { mutableListOf() } // 인접 리스트로 표현한 그래프 (인접노드idx to 해당노드까지의거리)
    val distances = MutableList(N){ Int.MAX_VALUE }
//    for (i: Int in 1..M) {
//        val input = readln().split(" ").map{ it.toInt() }
//        nodes[input[0] - 1].add(input[1] - 1 to input[2])
//    }
    nodes[0] = mutableListOf(1 to 2, 2 to 5)
    nodes[1] = mutableListOf(2 to 1)
    val start = 0 // 시작 노드
    val end = 2 // 끝 노드
    distances[start] = 0
    val queue = mutableListOf<Pair<Int, Int>>() // (노드번호 to 시작 노드에서 해당 노드까지의 거리)
    queue.add(start to 0) // 시작 노드에서 부터 시작
    while (queue.isNotEmpty()) {
        val first = queue.first()
        val curNode = nodes[first.first]
        val distance = first.second
        queue.removeFirst()
        if (distances[first.first] < distance) continue // 이전에 구한 거리보다 크면 건너뜀
        for (node: Pair<Int, Int> in curNode) {
            if (node.second + distance < distances[node.first]) { // 이전 노드에서 현재 노드까지 거리 + 이전 노드까지의 거리가 최단거리이면
                distances[node.first] = node.second + distance // 최단거리를 업데이트
                queue.add(node.first to distances[node.first])
            }
        }
    }
    println(distances)
}
