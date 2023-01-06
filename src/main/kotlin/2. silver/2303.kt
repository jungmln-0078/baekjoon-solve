fun main() {
    val N = readln().toInt()
    val cards = mutableListOf<MutableList<Int>>()
    for (i: Int in 1..N) {
        cards.add(readln().split(" ").map { it.toInt() }.toMutableList())
    }
    var max = -1
    var result = 0
    for (i: Int in cards.indices) {
        val sum = listOf(
            (cards[i][0] + cards[i][1] + cards[i][2]).toString().last().digitToInt(),
            (cards[i][0] + cards[i][1] + cards[i][3]).toString().last().digitToInt(),
            (cards[i][0] + cards[i][1] + cards[i][4]).toString().last().digitToInt(),
            (cards[i][1] + cards[i][2] + cards[i][3]).toString().last().digitToInt(),
            (cards[i][1] + cards[i][2] + cards[i][4]).toString().last().digitToInt(),
            (cards[i][2] + cards[i][3] + cards[i][4]).toString().last().digitToInt(),
            (cards[i][0] + cards[i][2] + cards[i][3]).toString().last().digitToInt(),
            (cards[i][0] + cards[i][2] + cards[i][4]).toString().last().digitToInt(),
            (cards[i][0] + cards[i][3] + cards[i][4]).toString().last().digitToInt(),
            (cards[i][1] + cards[i][3] + cards[i][4]).toString().last().digitToInt(),
        ).max()
        if (sum >= max) {
            max = sum
            result = i + 1
        }
    }
    println(result)
}
