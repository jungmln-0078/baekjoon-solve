import java.math.BigInteger

val input24447 = readln().split(" ")
val N24447 = input24447[0].toInt()
val M24447 = input24447[1].toInt()
val R24447 = input24447[2].toInt()
val graph24447 = MutableList<MutableList<Int>>(N24447 + 1){ mutableListOf() }
val graphD = MutableList(N24447 + 1){ -1 }
val graphT = MutableList(N24447 + 1){ 0 }
val graphBFSVisited24447 = MutableList(N24447 + 1){ false }
val graphBFSQueue24447 = mutableListOf<Pair<Int, Int>>()
fun main() {
    for (i: Int in 1..M24447) {
        val vertex = readln().split(" ").map { it.toInt() }
        graph24447[vertex[0]].add(vertex[1])
        graph24447[vertex[1]].add(vertex[0])
    }
    var t = 0
    var result: BigInteger = BigInteger.ZERO
    graphBFSVisited24447[R24447] = true
    graphBFSQueue24447.add(R24447 to 0)
    while (graphBFSQueue24447.isNotEmpty()) {
        val node = graphBFSQueue24447.first()
        graphBFSQueue24447.removeFirst()
        graphD[node.first] = node.second
        graphT[node.first] = ++t
        graph24447[node.first].sort()
        result += graphT[node.first].toBigInteger() * graphD[node.first].toBigInteger()
        for (i: Int in graph24447[node.first]) {
            if (!graphBFSVisited24447[i])  {
                graphBFSVisited24447[i] = true
                graphBFSQueue24447.add(i to node.second + 1)
            }
        }
    }
    println(result)
}
