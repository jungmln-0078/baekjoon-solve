fun main() {
    val L = readln().toInt()
    val scores = readln().split(" ").map { it.toLong() }
    val results = mutableListOf<Pair<Long, Long>>()
    for (i: Long in 1.toLong()..scores.size) {
        var s: Long = 0
        for (d: Long in -1 + i..scores.lastIndex step i) {
            s += scores[d.toInt()]
        }
        results.add(i to s)
    }
    val max = results.sortedWith(compareBy({ -it.second }, { it.first })).first()
    println(if (max.second <= 0) "0 0" else "${max.first} ${max.second}")
}
