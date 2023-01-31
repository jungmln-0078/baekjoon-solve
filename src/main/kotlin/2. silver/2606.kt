import java.util.LinkedList
val computers = readln().toInt()
val N = readln().toInt()
val tree = MutableList<LinkedList<Int>>(computers + 1){ LinkedList() }
val visited = MutableList(computers + 1){ false }
var count = 0
fun main() {
    for (i: Int in 1..N) {
        val input = readln().split(" ").map { it.toInt() }
        tree[input[0]].add(input[1])
        tree[input[1]].add(input[0])
    }
    DFS2606(1)
    println(count)
}

fun DFS2606(start: Int) {
    if (visited[start]) return
    visited[start] = true
    val curNode = tree[start]
    if (start != 1) count++
    for (i: Int in curNode.indices) {
        DFS2606(curNode[i])
    }
}
