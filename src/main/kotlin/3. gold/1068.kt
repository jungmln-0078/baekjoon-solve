import java.util.LinkedList

val N1068 = readln().toInt()
val input1068 = readln().split(" ").map { it.toInt() }
val delete1068 = readln().toInt()
val tree1068 = MutableList<MutableList<Int>?>(N1068){ LinkedList() }
val visited1068 = MutableList(N1068) { false }
fun main() {
    var rootNum = 0
    for (i: Int in input1068.indices) {
        if (input1068[i] != -1) {
            tree1068[input1068[i]]!!.add(i)
        } else rootNum = i
    }
    DFS1068(rootNum, delete1068)
    println(tree1068.filter { it != null && it.isEmpty() }.size)
}

fun DFS1068(start: Int, delete: Int) {
    if (visited1068[start]) return
    visited1068[start] = true
    if (tree1068[start] != null) {
        val curNode = tree1068[start]!!
        for (i: Int in curNode.indices) {
            if (i > curNode.lastIndex || visited1068[curNode[i]]) break
            if (curNode[i] == delete || start == delete) {
                DFS1068(curNode[i], curNode[i])
                curNode.remove(delete)
            } else {
                DFS1068(curNode[i], delete)
            }
        }
    }
    if (start == delete) {
        tree1068[start] = null
    }
}
