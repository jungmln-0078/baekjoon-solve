val input14267 = readln().split(" ")
val n14267 = input14267[0].toInt()
val m14267 = input14267[1].toInt()
val tree14267 = MutableList<MutableList<Int>>(n14267) { mutableListOf() }
val treeStr = readln().split(" ").map { it.toInt() }
var score14267 = MutableList(n14267) { 0 }
var DFSvisited14267 = MutableList(n14267) { false }
var DPvisited14267 = MutableList(n14267) { false }
fun main() {
    for (i: Int in treeStr.indices) {
        if (i > 0) {
            tree14267[treeStr[i] - 1].add(i)
        }
    }
    for (i: Int in 1..m14267) {
        val input = readln().split(" ").map { it.toInt() }
        score14267[input[0] - 1] += input[1]
    }
    DFS14267(0)
    println(score14267.joinToString(" "))
}

fun DP14267(start: Int): Int {
    if (DPvisited14267[start] || start == 0) return score14267[start]
    score14267[start] += DP14267(treeStr[start] - 1)
    DPvisited14267[start] = true
    return score14267[start]
}

fun DFS14267(start: Int) {
    if (DFSvisited14267[start]) return
    DFSvisited14267[start] = true
    val curNode = tree14267[start]
    DP14267(start)
    for (i: Int in curNode.indices) {
        if (!DFSvisited14267[curNode[i]]) DFS14267(curNode[i])
    }
}
