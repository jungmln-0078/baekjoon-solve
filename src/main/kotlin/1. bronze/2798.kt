val M = readln().split(" ")[1].toInt()
val cards = readln().split(" ").map { it.toInt() }
val combi = mutableListOf<Int>()
val sumList = mutableListOf<Int>()
fun main() {
    comb(0, 3, 0)
    println(sumList.filter{ it <= M }.max())
}

fun comb(count: Int, depth: Int, beginWith: Int) {
    if (count == depth) {
        sumList.add(combi.sum())
        return
    }
    for (index in beginWith until cards.size) {
        combi.add(cards[index])
        comb(count + 1, depth, index + 1)
        combi.removeAt(combi.lastIndex)
    }
}
