package algorithm
/* 깊이 우선 탐색, 너비 우선 탐색
https://mujilog.tistory.com/entry/%EA%B7%B8%EB%9E%98%ED%94%84-%EC%9D%B4%EB%A1%A0-BFSDFS-%EA%B5%AC%ED%98%84%ED%95%B4%EB%B3%B4%EA%B8%B0?category=1264398
 */

val N = 5
val tree = MutableList<MutableList<Int>>(N) { mutableListOf() }
val treeDFSVisited = MutableList(N){ false }
val treeBFSVisited = MutableList(N){ false }
val M = 5
val graph = MutableList<MutableList<Int>>(M) { mutableListOf() }
val graphDFSVisited = MutableList(M){ false }
val graphBFSVisited = MutableList(M){ false }
fun main() {
    /* 트리를 초기화
        각 인덱스가 노드의 번호
        입력값은 해당 노드의 부모 노드의 번호 (루트 노드는 -1)
        노드의 갯수만큼의 인접 리스트를 생성하여 각 인덱스에 해당 노드의 자식 노드 번호를 넣는다.
     */
    val treeInput = "-1 0 1 1 2"
    treeInput.split(" ").forEachIndexed { index, s ->
        run {
            val i = s.toInt()
            if (i != -1) {
                tree[i].add(index)
            }
        }
    }
    println(tree)
    /* 그래프를 초기화
        간선의 목록이 주어질 때 양방향 그래프를 초기화하려면
        트리처럼 정점의 수만큼의 인접 리스트를 생성하고
        각 간선 u v 에 대하여
        graph[u]에 v를 추가,
        graph[v]에 u를 추가하여 양방향을 표현한다.
     */
    val graphInput = listOf("0 1", "1 2", "3 4", "4 1", "1 3")
    graphInput.forEach {
        val a = it.split(" ")[0].toInt()
        val b = it.split(" ")[1].toInt()
        graph[a].add(b)
        graph[b].add(a)
    }
    println(graph)

    println("treeDFS")
    treeDFS(0)
    println("graphDFS")
    graphDFS(0)
    println("treeBFS")
    treeBFS(0)
    println("graphBFS")
    graphBFS(0)
}

fun treeDFS(start: Int) {
    if (treeDFSVisited[start]) return
    treeDFSVisited[start] = true
    val curNode = tree[start]
    println(start)
    for (i: Int in curNode.indices) {
        if (!treeDFSVisited[curNode[i]]) treeDFS(curNode[i])
    }
}

fun treeBFS(start: Int) {
    val queue = mutableListOf<Int>()
    treeBFSVisited[start] = true
    queue.add(start)
    while (queue.isNotEmpty()) {
        val n = queue.first()
        queue.removeFirst()
        println(n)
        for (i: Int in tree[n]) {
            if (!treeBFSVisited[i])  {
                treeBFSVisited[i] = true
                queue.add(i)
            }
        }
    }
}

fun graphDFS(start: Int) {
    if (graphDFSVisited[start]) return
    graphDFSVisited[start] = true
    val curNode = graph[start]
    println(start)
    for (i: Int in curNode.indices) {
        if (!graphDFSVisited[curNode[i]]) graphDFS(curNode[i])
    }
}

fun graphBFS(start: Int) {
    val queue = mutableListOf<Int>()
    graphBFSVisited[start] = true
    queue.add(start)
    while (queue.isNotEmpty()) {
        val n = queue.first()
        queue.removeFirst()
        println(n)
        for (i: Int in graph[n]) {
            if (!graphBFSVisited[i])  {
                graphBFSVisited[i] = true
                queue.add(i)
            }
        }
    }
}
