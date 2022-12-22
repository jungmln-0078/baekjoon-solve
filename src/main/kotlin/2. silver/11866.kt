fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val N = input[0]
    val K = input[1]
    val list = (1..N).toMutableList()
    val answer = mutableListOf<Int>()
    var idxToRemove = K - 1
    while (true) {
        answer.add(list[idxToRemove])
        list.removeAt(idxToRemove)
        idxToRemove += K - 1
        if (list.size == 0) break;
        if (idxToRemove > list.lastIndex) {
            idxToRemove %= list.size
        }
    }
    println("<${answer.joinToString(", ")}>")
}
