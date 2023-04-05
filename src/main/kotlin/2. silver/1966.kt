fun main() {
    val tcs = readln().toInt()
    for (tc: Int in 1..tcs) {
        val (N, M) = readln().split(" ").map { it.toInt() }
        val queue = readln().split(" ").mapIndexed { index, s -> index to s.toInt() }.toMutableList()
        var i = 0
        while (true) {
            val doc = queue.first()
            val moreImportant = queue.indexOfFirst { doc.second < it.second }
            if (moreImportant != -1) {
                queue.removeFirst()
                queue.add(doc)
                continue
            } else {
                queue.removeFirst()
                i++
            }
            if (doc.first == M) {
                println(i)
                break
            }
        }
    }
}
